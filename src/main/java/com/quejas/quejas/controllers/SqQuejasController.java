/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.dtos.BusquedaFiltrosDto;
import com.quejas.quejas.dtos.FiltrosDto;
import com.quejas.quejas.modelo.SqQuejas;
import com.quejas.quejas.projections.SqCentralizadorProjection;
import com.quejas.quejas.projections.SqQueja;
import com.quejas.quejas.servicios.SqQuejasService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilson
 */
@Api
@RestController
@Slf4j
@RequestMapping("/queja")
@CrossOrigin("*")
public class SqQuejasController {

    @Autowired
    SqQuejasService sqQuejasService;

    @PostMapping(value = "/crear")
    public void crearQueja(@Valid @RequestBody SqQuejas queja) {
        sqQuejasService.crearQueja(queja);
    }

    @GetMapping(value = "/listar/{pCreador}")
    public List<SqQuejas> listarQuejaUsuario(@Valid @PathVariable Long pCreador) {
        try {
            return sqQuejasService.listarQuejaUsuario(pCreador);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/queja/{pQueja}")
    public SqQueja obtenerCantidadPa(@Valid @PathVariable Integer pQueja) {
        try {
            return sqQuejasService.obtenerQueja(pQueja);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/centralizador")
    public List<SqCentralizadorProjection> obtenerQuejas() {
        return sqQuejasService.obtenerQuejas();
    }

    @GetMapping(value = "/byId/{idQueja}")
    public SqQuejas obtenerQuejaById(@Valid @PathVariable Long idQueja) {
        try {
            return sqQuejasService.obtenerQuejaById(idQueja);
        } catch (Exception e) {
            return null;
        }
    }
    
    @PutMapping(value= "/{idQueja}/justificacion")
    public SqQuejas NoJustifica (@PathVariable Long codigoQueja, @RequestParam String justificacion){
        return sqQuejasService.modificarJustificacion(codigoQueja, justificacion);
    }
    
    @PostMapping(value="/asignar")
    public boolean asignar(@Valid @RequestBody SqAsignarDto pQueja){
        return sqQuejasService.asignar(pQueja);
    }
    
    @GetMapping(value = "/asignadas")
    public List<SqCentralizadorProjection> obtenerQuejasAsignadas() {
        return sqQuejasService.obtenerQuejasAsignadas();
    }
    
    @GetMapping(value = "/operador")
    public List<SqCentralizadorProjection> obtenerQuejasReanalisis() {
        return sqQuejasService.obtenerQuejasReanalisis();
    }

    @PostMapping(value="/obtenerFiltros")
    public List<FiltrosDto> obtenerFiltros(@Valid @RequestBody BusquedaFiltrosDto param){
        return sqQuejasService.obtenerFiltros(param);
    }
    
}
