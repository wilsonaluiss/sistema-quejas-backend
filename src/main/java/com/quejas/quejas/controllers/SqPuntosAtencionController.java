/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.dtos.SqContadorPuntosAtencionDto;
import com.quejas.quejas.dtos.SqPuntosAtencionDto;
import com.quejas.quejas.modelo.PuntosAtencion;
import com.quejas.quejas.modelo.SqCantidadPaProjection;
import com.quejas.quejas.servicios.PuntosAtencionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilson
 */
@Api
@RestController
@Slf4j
@RequestMapping("/patencion")
@CrossOrigin("*")
public class SqPuntosAtencionController {
    
    @Autowired
    PuntosAtencionService puntosAtencionService;
    
    @PostMapping(value = "/crear")
    @ApiOperation(value = "Crear un evento")
    public void crearEvento(@Valid @RequestBody SqPuntosAtencionDto eventoDto) {
        puntosAtencionService.crearPunto(eventoDto);
    }
    
    
    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obtiene la lista de los puntos de atención")
    public List<PuntosAtencion> listarPuntosAtencion() {
        try {
            return puntosAtencionService.listarPuntosAtencion();
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping(value = "/{idPatencion}")
    public PuntosAtencion obtenerPatencionById(@Valid @PathVariable Long idPatencion){
        try {
            return puntosAtencionService.obtenerPatencionById(idPatencion);
        } catch (Exception e) {
            log.debug("Error al consultar id del punto de atención");
            return null;
        }
    }
    
    
    @PostMapping(value ="/modificar/pa")
    @ApiOperation(value = "Obtiene la lista de los puntos de atención")
    public boolean actualizarPantencion(@RequestBody PuntosAtencion pAtencion){
        return puntosAtencionService.actualizarPantencion(pAtencion);
    }
    
    @GetMapping(value="/activa/{pRegion}")
    public List<PuntosAtencion>obtenerPuntoRegional(@Valid @PathVariable Integer pRegion){
        return puntosAtencionService.obtenerPuntoRegional(pRegion);
    }
    
    @GetMapping(value="/cantidad/{pRegion}")
    public SqCantidadPaProjection obtenerCantidadPa(@Valid @PathVariable Integer pRegion){
        try {
            return puntosAtencionService.obtenerCantidadPa(pRegion);
        } catch (Exception e) {
            return null;
        }
    }
}
