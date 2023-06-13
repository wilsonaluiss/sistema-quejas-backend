/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import com.quejas.quejas.modelo.SqTipoQuejas;
import com.quejas.quejas.repository.SqTipoQuejasRepository;
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
public class SqTipoQuejasService {
    
    @Autowired
    SqTipoQuejasRepository sqTipoQuejasRepository;
    
    @Transactional(rollbackFor = {Exception.class})
    public SqTipoQuejas crearTipoQueja(SqTipoQuejas tipoQueja) {
        SqTipoQuejas tiposQueja = sqTipoQuejasRepository.save(
                SqTipoQuejas.builder()
                        .codigoTipoQueja(tipoQueja.getCodigoTipoQueja())
                        .codigoEstado(tipoQueja.getCodigoEstado())
                        .siglas(tipoQueja.getSiglas())
                        .descripcionTipoQueja(tipoQueja.getDescripcionTipoQueja())
                        .usuarioAgrega(tipoQueja.getUsuarioAgrega())
                        .ipUsuarioAgrega(tipoQueja.getIpUsuarioAgrega())
                        .fechaAgrega(tipoQueja.getFechaAgrega())
                        .fechaModifica(tipoQueja.getFechaModifica())
                        .build()
        );
        return tiposQueja;
    }
    
    public List<SqTipoQuejas> listarTipoQuejas() {
        return (List<SqTipoQuejas>) sqTipoQuejasRepository.obtenerTiposQuejas();
    }
    
    public SqTipoQuejas obtenerTipoQueja(Long tipoQueja) {
        log.debug("Consultando el id del punto de la queja");
        try {
            return sqTipoQuejasRepository.obtenerTipoQueja(tipoQueja);
        } catch (Exception e) {
            log.debug("Error al consultar id del punto de la queja");
            return null;
        }
    }
    
    public boolean actualizarTipoQueja(SqTipoQuejas tipoQueja) {
        List<SqTipoQuejas> tiposQuejas = sqTipoQuejasRepository.findByCodigoTipoQueja(tipoQueja.getCodigoTipoQueja());
        if (!tiposQuejas.isEmpty()) {
            tiposQuejas.get(0).setCodigoEstado(tipoQueja.getCodigoEstado());
            tiposQuejas.get(0).setSiglas(tipoQueja.getSiglas());
            tiposQuejas.get(0).setDescripcionTipoQueja(tipoQueja.getDescripcionTipoQueja());
            tiposQuejas.get(0).setFechaAgrega(tipoQueja.getFechaAgrega());
            tiposQuejas.get(0).setFechaModifica(tipoQueja.getFechaModifica());
            sqTipoQuejasRepository.save(tiposQuejas.get(0));
            return true;
        }
        return false;
    }
    
    
    
}
