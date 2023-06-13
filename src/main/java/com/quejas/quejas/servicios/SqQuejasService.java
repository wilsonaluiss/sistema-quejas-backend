/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import com.quejas.quejas.controllers.SqAsignarDto;
import com.quejas.quejas.dtos.BusquedaFiltrosDto;
import com.quejas.quejas.dtos.FiltrosDto;
import com.quejas.quejas.modelo.SqCantidadPaProjection;
import com.quejas.quejas.modelo.SqQuejas;
import com.quejas.quejas.modelo.SqUsuariosPuntoAtencion;
import com.quejas.quejas.projections.SqCentralizadorProjection;
import com.quejas.quejas.projections.SqQueja;
import com.quejas.quejas.repository.SqQuejasRepository;
import com.quejas.quejas.repository.SqTipoQuejasRepository;
import java.util.ArrayList;
import java.util.List;
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
public class SqQuejasService {

    @Autowired
    SqQuejasRepository sqQuejasRepository;

    @Autowired
    SqTipoQuejasRepository sqTipoQuejasRepository;
    
    @Autowired
    GeneralRepository generalRepository;

    private List<SqQuejas> usuarios = new ArrayList<>();

    @Transactional(rollbackFor = {Exception.class})
    public SqQuejas crearQueja(SqQuejas queja) {
        SqQuejas crearQueja = sqQuejasRepository.save(
                SqQuejas.builder()
                        .codigoQueja(queja.getCodigoQueja())
                        .codigoEtapa(queja.getCodigoEtapa())
                        .codigoRegion(queja.getCodigoRegion())
                        .codigoTipoCreador(queja.getCodigoTipoCreador())
                        .codigoMedioIngreso(queja.getCodigoMedioIngreso())
                        .codigoEstadoExterno(queja.getCodigoEstadoExterno())
                        .codigoEstadoInterno(queja.getCodigoEstadoInterno())
                        .codigoTipoQueja(queja.getCodigoTipoQueja())
                        .codigoPuntoAtencion(queja.getCodigoPuntoAtencion())
                        .dpiUsuario(queja.getDpiUsuario())
                        .nombre(queja.getNombre())
                        .correoElectronico(queja.getCorreoElectronico())
                        .nombreEmpleado(queja.getNombreEmpleado())
                        .detalleQueja(queja.getDetalleQueja())
                        .correlativo(queja.getCorrelativo())
                        .documentoSoporte(queja.getDocumentoSoporte())
                        .justificacion(queja.getJustificacion())
                        .oficina(queja.getOficina())
                        .anioQueja(queja.getAnioQueja())
                        .usuarioAgrega(queja.getUsuarioAgrega())
                        .fechaAgrega(queja.getFechaAgrega())
                        .build()
        );
        return crearQueja;
    }

    public List<SqQuejas> listarQuejaUsuario(Long pCreador) {
        return (List<SqQuejas>) sqQuejasRepository.obtenerSolicitudes(pCreador);
    }

    public SqQueja obtenerQueja(Integer pQueja) {
        try {
            return sqTipoQuejasRepository.quejas(pQueja);
        } catch (Exception e) {
            log.debug("Error al consultar la cantidad de puntos de atencion");
            return null;
        }
    }

    public List<SqCentralizadorProjection> obtenerQuejas() {
        return (List<SqCentralizadorProjection>) sqQuejasRepository.obtenerQuejas();
    }

    public SqQuejas obtenerQuejaById(Long idQueja) {
        return sqQuejasRepository.obtenerQuejaById(idQueja);
    }

    public SqQuejas modificarJustificacion(Long codigoQueja, String Justificacion) {
        SqQuejas usuarioExistente = usuarios.stream()
                .filter(u -> u.getCodigoQueja().equals(codigoQueja))
                .findFirst()
                .orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setJustificacion(Justificacion);
        }
        return usuarioExistente;
    }

    public boolean asignar(SqAsignarDto pQueja) {
        try {
            System.out.println("entra?");
            sqQuejasRepository.findAllById(pQueja.getSolicitud()).forEach(solicitud -> {
                List<SqQuejas> eventos = sqQuejasRepository.findByCodigoQueja(solicitud.getCodigoQueja());
                System.out.println("eventos"+eventos);
                if (!eventos.isEmpty()) {
                    if (pQueja.getComplemento() == 1) {
                        solicitud.setCodigoEtapa(2);
                        solicitud.setCodigoEstadoExterno(2);
                        solicitud.setCodigoEstadoInterno(2);
                    }
                    if(pQueja.getComplemento() == 2){
                        solicitud.setCodigoEtapa(3);
                        solicitud.setCodigoEstadoExterno(3);
                        solicitud.setCodigoEstadoInterno(3);
                        solicitud.setJustificacion(pQueja.getJustificacion());
                    }
                    if(pQueja.getComplemento() == 3){
                        solicitud.setCodigoEtapa(4);
                        solicitud.setCodigoEstadoExterno(4);
                        solicitud.setCodigoEstadoInterno(4);
                        solicitud.setJustificacion(pQueja.getJustificacion());
                    }
                    if(pQueja.getComplemento() == 4){
                        solicitud.setCodigoEtapa(5);
                        solicitud.setCodigoEstadoExterno(5);
                        solicitud.setCodigoEstadoInterno(5);
                        solicitud.setJustificacion(pQueja.getJustificacion());
                    }
                    sqQuejasRepository.save(solicitud);
                }

            });
            return true;
        } catch (Exception e) {
            log.error("error" + e);
            return false;
        }
    }
    
    public List<SqCentralizadorProjection> obtenerQuejasAsignadas() {
        return (List<SqCentralizadorProjection>) sqQuejasRepository.obtenerQuejasAsignadas();
    }
    
    public List<SqCentralizadorProjection> obtenerQuejasReanalisis() {
        return (List<SqCentralizadorProjection>) sqQuejasRepository.obtenerQuejasReanalisis();
    }
    
    @Transactional(readOnly = true)
    public List<FiltrosDto> obtenerFiltros (BusquedaFiltrosDto param){
        System.out.println("entra?");
        return (List<FiltrosDto>) generalRepository.obtenerFiltros(param);
    }
}
