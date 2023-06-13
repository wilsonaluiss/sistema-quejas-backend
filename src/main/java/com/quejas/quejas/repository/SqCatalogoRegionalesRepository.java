/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.modelo.SqRegionales;
import com.quejas.quejas.projections.SqCatalogoRegionProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wilson
 */
public interface SqCatalogoRegionalesRepository extends CrudRepository<SqRegionales, Long>{
    
    @Query(value="select r.codigo_regional_id \"codigoRegionalId\", r.nombre_region \"nombreRegion\" from regionales r;",nativeQuery=true)
    public List<SqCatalogoRegionProjection> obtenerCatalogo();
}
