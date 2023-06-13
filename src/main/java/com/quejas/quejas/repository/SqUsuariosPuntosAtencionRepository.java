/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.modelo.PuntosAtencion;
import com.quejas.quejas.modelo.SqUsuariosPuntoAtencion;
import com.quejas.quejas.projections.SqContadorUsuariosPatencion;
import com.quejas.quejas.projections.SqEliminacionPatencionUsuarioProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wilson
 */
public interface SqUsuariosPuntosAtencionRepository extends CrudRepository<SqUsuariosPuntoAtencion, Long> {

    List<SqUsuariosPuntoAtencion> findByCodigoUsuarioPunto(Long Upatencion);

    @Query(value = "select * from public.usuarios_puntos_atencion upa where upa.codigo_usuario_punto =:Upatencion;", nativeQuery = true)
    SqUsuariosPuntoAtencion obtenerUpatencion(@Param("Upatencion") Long Upatencion);

    @Query(value = "select count(*) from public.usuarios_puntos_atencion upa where upa.dpi_usuario = :pDpi and upa.codigo_estado <> 2;", nativeQuery = true)
    public Integer validarDpi(@Param("pDpi") String pDpi);

    @Query(value = "select * from public.usuarios_puntos_atencion upa where upa.codigo_usuario_punto = :idUpatencion", nativeQuery = true)
    SqUsuariosPuntoAtencion obtenerUsuarioUpatencionById(@Param("idUpatencion") Long idUpatencion);

    @Query(value = "select * from public.usuarios_puntos_atencion upa where upa.codigo_estado = 1", nativeQuery = true)
    List<SqUsuariosPuntoAtencion> obtenerUsuariosPuntoAtencion();

    @Query(value = "select \n"
            + "(select count (upa.codigo_punto_atencion) from usuarios_puntos_atencion upa where upa.codigo_punto_atencion =:pcodigo and upa.codigo_estado = 1)cantidad", nativeQuery = true)
    SqContadorUsuariosPatencion contadorUsuario(@Param("pcodigo") Integer pcodigo);

    @Query(value = "select * from usuarios_puntos_atencion upa where upa.codigo_estado = 1 and upa.codigo_usuario_punto  =:pCodigo", nativeQuery = true)
    public SqUsuariosPuntoAtencion actualizarEstado(@Param("pCodigo") Long pCodigo);

    @Query(value = "select upa.codigo_usuario_punto \"codigoUsuarioPunto\"  from usuarios_puntos_atencion upa where upa.codigo_punto_atencion =:pAtencion and upa.codigo_estado = 1", nativeQuery = true)
    public List<SqEliminacionPatencionUsuarioProjection> solicitudes(@Param("pAtencion") Long pAtencion);
}
