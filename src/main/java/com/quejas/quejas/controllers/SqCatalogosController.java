/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.projections.SqCargoProjection;
import com.quejas.quejas.projections.SqCatalogoRegionProjection;
import com.quejas.quejas.servicios.SqCargoService;
import com.quejas.quejas.servicios.SqCatalogoRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilson
 */
@Api
@RestController
@Slf4j
@RequestMapping("/catalogos")
@CrossOrigin("*")
public class SqCatalogosController {

    @Autowired
    SqCatalogoRegionService sqCatalogoRegionService;
    
    @Autowired
    SqCargoService SqCargoService;

    @GetMapping(value = "/regiones")
    @ApiOperation(value = "Obtiene la lista de los puntos de atención")
    public List<SqCatalogoRegionProjection> obtenerRegiones() {
        return sqCatalogoRegionService.obtenerRegiones();
    }
    
    @GetMapping(value="/cargo")
    public List<SqCargoProjection> obtenerCargo(){
        return SqCargoService.obtenerCargo();
    }
    

}
