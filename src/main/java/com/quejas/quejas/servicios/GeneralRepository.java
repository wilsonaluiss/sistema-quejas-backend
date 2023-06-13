/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import com.quejas.quejas.dtos.BusquedaFiltrosDto;
import com.quejas.quejas.dtos.FiltrosDto;
import com.quejas.quejas.servicios.Utils.ReportesUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wilson
 */
@Repository
public class GeneralRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<FiltrosDto> obtenerFiltros(BusquedaFiltrosDto param) {
        String correlativo ="";
        if(!param.getCorrelativo().equals("")){
            correlativo = "and q.correlativo like concat ('%" + param.getCorrelativo() + "%')";
        }
        String query = "select q.codigo_queja, q.codigo_etapa, q.codigo_estado_externo, q.codigo_estado_interno, q.anio_queja, q.correlativo  \n"
                + "from public.quejas q \n";  
        return ReportesUtils.createCompiledQuery(entityManager, query, param, FiltrosDto.class).getResultList();
    }

}
