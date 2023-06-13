/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import com.quejas.quejas.dtos.SqActualizarEstadoDto;
import com.quejas.quejas.modelo.PuntosAtencion;
import com.quejas.quejas.modelo.SqUsuariosPuntoAtencion;
import com.quejas.quejas.projections.SqContadorUsuariosPatencion;
import com.quejas.quejas.projections.SqEliminacionPatencionUsuarioProjection;
import com.quejas.quejas.repository.SqUsuariosPuntosAtencionRepository;
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
public class SqUsuariosPuntosAtencionService {

    @Autowired
    SqUsuariosPuntosAtencionRepository sqUsuariosPuntosAtencionRepository;

    @Transactional(rollbackFor = {Exception.class})
    public SqUsuariosPuntoAtencion crearUsuarioPatencion(SqUsuariosPuntoAtencion uPatencion) {
        SqUsuariosPuntoAtencion patencionUsuarios = sqUsuariosPuntosAtencionRepository.save(
                SqUsuariosPuntoAtencion.builder()
                        .codigoUsuarioPunto(uPatencion.getCodigoUsuarioPunto())
                        .nombreUsuarioAtencion(uPatencion.getNombreUsuarioAtencion())
                        .regionPatencion(uPatencion.getRegionPatencion())
                        .codigoEstado(uPatencion.getCodigoEstado())
                        .codigoPuntoAtencion(uPatencion.getCodigoPuntoAtencion())
                        .dpiUsuario(uPatencion.getDpiUsuario())
                        .codigoCargo(uPatencion.getCodigoCargo())
                        .CorreoElectronico(uPatencion.getCorreoElectronico())
                        .UsuarioAgrega(uPatencion.getUsuarioAgrega())
                        .ipUsuarioAgrega(uPatencion.getIpUsuarioAgrega())
                        .fechaAgrega(uPatencion.getFechaAgrega())
                        .build()
        );
        return patencionUsuarios;
    }

    public List<SqUsuariosPuntoAtencion> listarUsuariosPuntoAtencion() {
        return (List<SqUsuariosPuntoAtencion>) sqUsuariosPuntosAtencionRepository.obtenerUsuariosPuntoAtencion();
    }

    public SqUsuariosPuntoAtencion obtenerUpatencion(Long Upatencion) {
        log.debug("Consultando el id del punto de atencion");
        try {
            return sqUsuariosPuntosAtencionRepository.obtenerUpatencion(Upatencion);
        } catch (Exception e) {
            log.debug("Error al consultar id del punto de atención");
            return null;
        }
    }

    public boolean actualizarUpantencion(SqUsuariosPuntoAtencion Upatencion) {
        List<SqUsuariosPuntoAtencion> usuarioPatencion = sqUsuariosPuntosAtencionRepository.findByCodigoUsuarioPunto(Upatencion.getCodigoUsuarioPunto());
        if (!usuarioPatencion.isEmpty()) {
            usuarioPatencion.get(0).setNombreUsuarioAtencion(Upatencion.getNombreUsuarioAtencion());
            usuarioPatencion.get(0).setRegionPatencion(Upatencion.getRegionPatencion());
            usuarioPatencion.get(0).setCodigoEstado(Upatencion.getCodigoEstado());
            usuarioPatencion.get(0).setCodigoPuntoAtencion(Upatencion.getCodigoPuntoAtencion());
            usuarioPatencion.get(0).setDpiUsuario(Upatencion.getDpiUsuario());
            usuarioPatencion.get(0).setCodigoCargo(Upatencion.getCodigoCargo());
            usuarioPatencion.get(0).setCorreoElectronico(Upatencion.getCorreoElectronico());
            usuarioPatencion.get(0).setUsuarioAgrega(Upatencion.getUsuarioAgrega());
            usuarioPatencion.get(0).setIpUsuarioAgrega(Upatencion.getIpUsuarioAgrega());
            usuarioPatencion.get(0).setFechaAgrega(Upatencion.getFechaAgrega());
            usuarioPatencion.get(0).setFechaModificacion(Upatencion.getFechaModificacion());
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public boolean validarDpi(String noDpi) {
        return sqUsuariosPuntosAtencionRepository.validarDpi(noDpi) > 0;
    }

    public SqUsuariosPuntoAtencion obtenerUsuarioUpatencionById(Long idUpatencion) {
        log.debug("Consultando el id del usuario punto de atencion");
        try {
            return sqUsuariosPuntosAtencionRepository.obtenerUsuarioUpatencionById(idUpatencion);
        } catch (Exception e) {
            log.debug("Error al consultar id del usuario del punto de atencion");
            return null;
        }
    }

    public SqContadorUsuariosPatencion obtenerCantidad(Integer pcodigo) {
        return sqUsuariosPuntosAtencionRepository.contadorUsuario(pcodigo);
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean actualizarSolicitudes(SqActualizarEstadoDto solicitudes) {
        System.out.println("tamanio"+solicitudes.getPCodigo().size());
        try {
            for (int i = 0; i < solicitudes.getPCodigo().size(); i++) {
                System.out.println("entro?");
                SqUsuariosPuntoAtencion estadoSolicitudes = sqUsuariosPuntosAtencionRepository.actualizarEstado(solicitudes.getPCodigo().get(i));
                estadoSolicitudes.setCodigoEstado(2);
            }
            return true;
        } catch (Exception e) {
            log.debug("error"+e);
            System.out.println("exception"+e);
            return false;
        }
    }
    
    public List<SqEliminacionPatencionUsuarioProjection> solicitudes(Long pAtencion){
        return sqUsuariosPuntosAtencionRepository.solicitudes(pAtencion);
    }
}
