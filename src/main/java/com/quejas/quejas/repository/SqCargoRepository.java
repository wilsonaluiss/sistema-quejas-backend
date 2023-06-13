/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.modelo.SqCargo;
import com.quejas.quejas.projections.SqCargoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wilson
 */
public interface SqCargoRepository extends CrudRepository<SqCargo, Long> {
    
    @Query(value="select c.codigo_cargo \"codigoCargo\", c.nombre_cargo \"nombreCargo\" from cargo c",nativeQuery=true)
    public List<SqCargoProjection> obtenerCargo();
    
}
