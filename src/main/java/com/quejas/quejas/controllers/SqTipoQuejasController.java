/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.modelo.SqTipoQuejas;
import com.quejas.quejas.servicios.SqTipoQuejasService;
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
@RequestMapping("/tipoQueja")
@CrossOrigin("*")
public class SqTipoQuejasController {
    
    @Autowired
    SqTipoQuejasService sqTipoQuejasService;
    
    @PostMapping(value = "/crear")
    @ApiOperation(value = "Crear un evento")
    public void crearTipoQueja(@Valid @RequestBody SqTipoQuejas tipoQueja) {
        sqTipoQuejasService.crearTipoQueja(tipoQueja);
    }
    
    @GetMapping(value = "/listar")
    @ApiOperation(value = "Obtiene la lista de las quejas")
    public List<SqTipoQuejas> listarTipoQuejas() {
        try {
            return sqTipoQuejasService.listarTipoQuejas();
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping(value = "/{tipoQueja}")
    public SqTipoQuejas obtenerTipoQueja(@Valid @PathVariable Long tipoQueja){
        try {
            return sqTipoQuejasService.obtenerTipoQueja(tipoQueja);
        } catch (Exception e) {
            log.debug("Error al consultar id del punto de atención");
            return null;
        }
    }
    
    
    @PostMapping(value ="/modificar/queja")
    @ApiOperation(value = "Obtiene la lista de los puntos de atención")
    public boolean actualizarPantencion(@RequestBody SqTipoQuejas tipoQueja){
        return sqTipoQuejasService.actualizarTipoQueja(tipoQueja);
    }
    
}
