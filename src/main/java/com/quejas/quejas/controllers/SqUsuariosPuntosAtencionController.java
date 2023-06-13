/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.dtos.SqActualizarEstadoDto;
import com.quejas.quejas.modelo.SqUsuariosPuntoAtencion;
import com.quejas.quejas.projections.SqContadorUsuariosPatencion;
import com.quejas.quejas.projections.SqEliminacionPatencionUsuarioProjection;
import com.quejas.quejas.servicios.SqUsuariosPuntosAtencionService;
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
@RequestMapping("/upatencion")
@CrossOrigin("*")
public class SqUsuariosPuntosAtencionController {
    
    
    @Autowired
    SqUsuariosPuntosAtencionService sqUsuariosPuntosAtencionService;
    
    @PostMapping(value = "/crear")
    @ApiOperation(value = "Crear un evento")
    public void crearTipoQueja(@Valid @RequestBody SqUsuariosPuntoAtencion Upatencion) {
        sqUsuariosPuntosAtencionService.crearUsuarioPatencion(Upatencion);
    }
    
    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obtiene la lista de los usuarios de punto de atención")
    public List<SqUsuariosPuntoAtencion> listarUsuariosPuntoAtencion() {
        try {
            return sqUsuariosPuntosAtencionService.listarUsuariosPuntoAtencion();
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping(value ="/validar/dpi/{noDpi}")
    @ApiOperation(value = "Metodo que valida si ya existe un numero de dpi igual al que se desea ingresar")
    public boolean validarDpi(@Valid @PathVariable String noDpi){
        return sqUsuariosPuntosAtencionService.validarDpi(noDpi);
    }
    
    
    @GetMapping(value = "/detalle/{idUpatencion}")
    public SqUsuariosPuntoAtencion obtenerPatencionById(@Valid @PathVariable Long idUpatencion){
        try {
            return sqUsuariosPuntosAtencionService.obtenerUsuarioUpatencionById(idUpatencion);
        } catch (Exception e) {
            log.debug("Error al consultar id del punto de atención");
            return null;
        }
    }
    
    
    @PostMapping(value ="/modificar/upa")
    @ApiOperation(value = "Obtiene la lista de los puntos de atención")
    public boolean actualizarUpantencion(@RequestBody SqUsuariosPuntoAtencion pAtencion){
        return sqUsuariosPuntosAtencionService.actualizarUpantencion(pAtencion);
    }
    
    @GetMapping(value = "/cantidad/{pcodigo}")
    public SqContadorUsuariosPatencion obtenerCantidad(@Valid @PathVariable Integer pcodigo){
        return sqUsuariosPuntosAtencionService.obtenerCantidad(pcodigo);
    }
    
    @PostMapping(value ="/estadosm")
    public boolean actualizarSolicitudes(@RequestBody SqActualizarEstadoDto pCodigo){
        return sqUsuariosPuntosAtencionService.actualizarSolicitudes(pCodigo);
    }
    
    @GetMapping(value ="/solicitud/{pAtencion}")
    public List<SqEliminacionPatencionUsuarioProjection> solicitudes(@Valid @PathVariable Long pAtencion){
        try {
            return sqUsuariosPuntosAtencionService.solicitudes(pAtencion);
        } catch (Exception e) {
            log.debug("ERROR"+e);
            return null;
        }
    }
}
