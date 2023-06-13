/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.modelo.SqTipoQuejas;
import com.quejas.quejas.projections.SqQueja;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wilson
 */
public interface SqTipoQuejasRepository extends CrudRepository<SqTipoQuejas, Long> {

    List<SqTipoQuejas> findByCodigoTipoQueja(Long tipoQueja);

    @Query(value = "select * from tipos_quejas tq where  tq.codigo_tipo_queja =:tipoQueja ", nativeQuery = true)
    SqTipoQuejas obtenerTipoQueja(@Param("tipoQueja") Long tipoQueja);

    @Query(value = "select * from public.tipos_quejas tq where tq.codigo_estado <>2", nativeQuery = true)
    List<SqTipoQuejas> obtenerTiposQuejas();

    @Query(value = "select\n"
            + "(select count (q.codigo_tipo_queja) from quejas q where q.codigo_tipo_queja =:pQueja) queja;", nativeQuery = true)
    SqQueja quejas(@Param("pQueja") Integer pQueja);

    

}
