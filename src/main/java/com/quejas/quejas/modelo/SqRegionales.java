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
@Table(name = "regionales", schema = "")
public class SqRegionales implements java.io.Serializable {

    private Long codigoRegionalId;
    private String nombreRegion;
    private String descripcionRegional;
    private String usuarioAgrega;
    private String ipUsuarioAgrega;
    private Date fechaAgrega;

    public SqRegionales() {
    }

    public SqRegionales(Long codigoRegionalId, String nombreRegion, String descripcionRegional, String usuarioAgrega, String ipUsuarioAgrega, Date fechaAgrega) {
        this.codigoRegionalId = codigoRegionalId;
        this.nombreRegion = nombreRegion;
        this.descripcionRegional = descripcionRegional;
        this.usuarioAgrega = usuarioAgrega;
        this.ipUsuarioAgrega = ipUsuarioAgrega;
        this.fechaAgrega = fechaAgrega;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_regional_id", unique = true, nullable = false)

    public Long getCodigoRegionalId() {
        return codigoRegionalId;
    }

    public void setCodigoRegionalId(Long codigoRegionalId) {
        this.codigoRegionalId = codigoRegionalId;
    }

    @Column(name = "nombre_region")
    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    @Column(name = "descripcion_regional")
    public String getDescripcionRegional() {
        return descripcionRegional;
    }

    public void setDescripcionRegional(String descripcionRegional) {
        this.descripcionRegional = descripcionRegional;
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
