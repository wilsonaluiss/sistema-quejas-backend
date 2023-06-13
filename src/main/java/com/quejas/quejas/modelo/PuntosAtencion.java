/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Builder;

/**
 *
 * @author Wilson
 */
@Entity
@Builder
@Table(name = "puntos_atencion", schema = "")
public class PuntosAtencion implements java.io.Serializable {

    private Long codigoAtencionId;
    private int regionPatencion;
    private String nombrePatencion;
    private Integer estado;
    private String usuarioAgrega;
    private String ipUsuarioAgrega;
    private Date fechaAgrega;

    public PuntosAtencion() {
    }

    public PuntosAtencion(Long codigoAtencionId, int regionPatencion, String nombrePatencion, Integer estado, String usuarioAgrega, String ipUsuarioAgrega, Date fechaAgrega) {
        this.codigoAtencionId = codigoAtencionId;
        this.regionPatencion = regionPatencion;
        this.nombrePatencion = nombrePatencion;
        this.estado = estado;
        this.usuarioAgrega = usuarioAgrega;
        this.ipUsuarioAgrega = ipUsuarioAgrega;
        this.fechaAgrega = fechaAgrega;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_atencion_id", unique = true, nullable = false)
    public Long getCodigoAtencionId() {
        return codigoAtencionId;
    }

    public void setCodigoAtencionId(Long codigoAtencionId) {
        this.codigoAtencionId = codigoAtencionId;
    }
    

    @Column(name = "region_patencion")
    public int getRegionPatencion() {
        return regionPatencion;
    }

    public void setRegionPatencion(int regionPatencion) {
        this.regionPatencion = regionPatencion;
    }
    

    @Column(name = "nombre_patencion")
    public String getNombrePatencion() {
        return nombrePatencion;
    }

    public void setNombrePatencion(String nombrePatencion) {
        this.nombrePatencion = nombrePatencion;
    }
   

    @Column(name = "estado")
    public Integer getEstado() {
        return estado;
    }


    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Column(name = "usuario_agrega")
    public String getUsuarioAgrega() {
        return usuarioAgrega;
    }

    public void setUsuarioAgrega(String usuarioAgrega) {
        this.usuarioAgrega = usuarioAgrega;
    }

    @Column(name = "ip_usuario_agrega")
    public String getIpUsuarioAgrega() {
        return ipUsuarioAgrega;
    }

    public void setIpUsuarioAgrega(String ipUsuarioAgrega) {
        this.ipUsuarioAgrega = ipUsuarioAgrega;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_agrega")
    public Date getFechaAgrega() {
        return fechaAgrega;
    }

    public void setFechaAgrega(Date fechaAgrega) {
        this.fechaAgrega = fechaAgrega;
    }

}
