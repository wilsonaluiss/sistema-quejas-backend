/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import com.quejas.quejas.dtos.SqContadorPuntosAtencionDto;
import com.quejas.quejas.dtos.SqPuntosAtencionDto;
import com.quejas.quejas.modelo.PuntosAtencion;
import com.quejas.quejas.modelo.SqCantidadPaProjection;
import com.quejas.quejas.repository.PuntosAtencionRepository;
import java.util.List;
//import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wilson
 */
@Service
@Transactional
@Slf4j
public class PuntosAtencionService {
    
    @Autowired
    PuntosAtencionRepository puntosAtencionRepository;
    
    @Transactional(rollbackFor = {Exception.class})
    public PuntosAtencion crearPunto(SqPuntosAtencionDto pAtencion){
        
        PuntosAtencion atencion = puntosAtencionRepository.save(
                PuntosAtencion.builder()
                        .codigoAtencionId(pAtencion.getCodigoAtencionId())
                        .regionPatencion(pAtencion.getRegionPatencion())
                        .nombrePatencion(pAtencion.getNombrePatencion())
                        .estado(pAtencion.getEstado())
                        .usuarioAgrega(pAtencion.getUsuarioAgrega())
                        .ipUsuarioAgrega(pAtencion.getIpUsuarioAgrega())
                        .fechaAgrega(pAtencion.getFechaAgrega())
                .build()
        );
        
        return atencion;
    }
    
    public List<PuntosAtencion> listarPuntosAtencion(){
        return (List<PuntosAtencion> ) puntosAtencionRepository.obtenerSolicitudes();
    }
    
    
    
    public PuntosAtencion obtenerPatencionById(Long idPatencion){
        log.debug("Consultando el id del punto de atencion");
        try {
            return puntosAtencionRepository.obtenerPatencionById(idPatencion);
        } catch (Exception e) {
            log.debug("Error al consultar id del punto de atención");
            return null;
        }
    }
    
    
    public boolean actualizarPantencion (PuntosAtencion pAtencion){
        List<PuntosAtencion> actPantencion = puntosAtencionRepository.findBycodigoAtencionId(pAtencion.getCodigoAtencionId());
        if(!actPantencion.isEmpty()){
            actPantencion.get(0).setNombrePatencion(pAtencion.getNombrePatencion());
            actPantencion.get(0).setRegionPatencion(pAtencion.getRegionPatencion());
            actPantencion.get(0).setEstado(pAtencion.getEstado());
            actPantencion.get(0).setUsuarioAgrega(pAtencion.getIpUsuarioAgrega());
            actPantencion.get(0).setFechaAgrega(pAtencion.getFechaAgrega());
            puntosAtencionRepository.save(actPantencion.get(0));
            return true;
        }
        return false;
    }
    
    
    public List<PuntosAtencion> obtenerPuntoRegional(Integer pRegion){
        return puntosAtencionRepository.obtenerPuntoRegional(pRegion);
    }
    
    public SqCantidadPaProjection obtenerCantidadPa(Integer pRegion){
        try {
            return puntosAtencionRepository.obtenerCantidadPa(pRegion);
        } catch (Exception e) {
            log.debug("Error al consultar la cantidad de puntos de atencion");
            return null;
        }
    }
}
