/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.dtos.SqContadorPuntosAtencionDto;
import com.quejas.quejas.modelo.PuntosAtencion;
import com.quejas.quejas.modelo.SqCantidadPaProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wilson
 */
public interface PuntosAtencionRepository extends CrudRepository<PuntosAtencion, Long> {

    @Query(value = "select * from public.puntos_atencion pa where pa.codigo_atencion_id =:idPatencion", nativeQuery = true)
    PuntosAtencion obtenerPatencionById(@Param("idPatencion") Long idPatencion);

    @Query(value = "select * from puntos_atencion pa where pa.region_patencion =:pRegion and pa.estado = 1", nativeQuery = true)
    List<PuntosAtencion> obtenerPuntoRegional(@Param("pRegion") Integer pRegion);

    List<PuntosAtencion> findBycodigoAtencionId(Long pAtencion);

    @Query(value = "select\n"
            + "(select  count (pa.region_patencion)  from puntos_atencion pa  where pa.region_patencion =:pRegion and pa.estado = 1) cantidad", nativeQuery = true)
    SqCantidadPaProjection obtenerCantidadPa(@Param("pRegion") Integer pRegion);

    @Query(value = "select * from puntos_atencion pa where pa.estado = 1\n"
            + "order by pa.codigo_atencion_id desc ", nativeQuery = true)
    List<PuntosAtencion> obtenerSolicitudes();

}
