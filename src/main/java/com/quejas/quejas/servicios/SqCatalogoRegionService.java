/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import com.quejas.quejas.projections.SqCatalogoRegionProjection;
import com.quejas.quejas.repository.SqCatalogoRegionalesRepository;
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
public class SqCatalogoRegionService {
    
    @Autowired
    SqCatalogoRegionalesRepository sqCatalogoRegionalesRepository;
    
    public List<SqCatalogoRegionProjection> obtenerRegiones(){
        return (List<SqCatalogoRegionProjection>) sqCatalogoRegionalesRepository.obtenerCatalogo();
    }
    
}
