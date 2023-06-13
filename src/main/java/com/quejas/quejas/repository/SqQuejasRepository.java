/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.modelo.SqQuejas;
import com.quejas.quejas.projections.SqCentralizadorProjection;
import com.quejas.quejas.projections.SqQueja;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wilson
 */
public interface SqQuejasRepository extends CrudRepository<SqQuejas, Long> {

    List<SqQuejas> findByCodigoQueja(Long codigoQueja);

    @Query(value = "select * from public.quejas q where codigo_tipo_creador =:pCreador", nativeQuery = true)
    List<SqQuejas> obtenerSolicitudes(@Param("pCreador") Long pCreador);

    @Query(value = "select p.codigo_queja \"codigoQueja\",  p.correlativo , p.fecha_agrega \"fechaHora\" from quejas p\n"
            + "where p.codigo_estado_interno =1 and p.codigo_estado_externo = 1 \n"
            + "order by p.fecha_agrega desc;", nativeQuery = true)
    List<SqCentralizadorProjection> obtenerQuejas();

    @Query(value = "select * from quejas where codigo_queja =:idQueja", nativeQuery = true)
    SqQuejas obtenerQuejaById(@Param("idQueja") Long idQueja);

    @Query(value = "select p.codigo_queja \"codigoQueja\",  p.correlativo , p.fecha_agrega \"fechaHora\", p.codigo_etapa \"codigoEtapa\", p.detalle_queja \"detalleQueja\" from quejas p\n"
            + "where p.codigo_estado_interno =2 and p.codigo_estado_externo = 2\n"
            + "order by p.fecha_agrega desc;", nativeQuery = true)
    List<SqCentralizadorProjection> obtenerQuejasAsignadas();
    
    
    @Query(value = "select p.codigo_queja \"codigoQueja\",  p.correlativo , p.fecha_agrega \"fechaHora\", p.codigo_etapa \"codigoEtapa\", p.detalle_queja \"detalleQueja\" from quejas p\n"
            + "where p.codigo_estado_interno =5 and p.codigo_estado_externo = 5\n"
            + "order by p.fecha_agrega desc;", nativeQuery = true)
    List<SqCentralizadorProjection> obtenerQuejasReanalisis();
    

}
