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
@Table(name = "cargo", schema = "")
public class SqCargo implements java.io.Serializable {
    
    private Long codigoCargo;
    private String nombreCargo;
    private String descripcionCargo;
    private String UsuarioAgrega;
    private String ipUsuarioAgrega;
    private Date fechaAgrega;

    public SqCargo() {
    }

    public SqCargo(Long codigoCargo, String nombreCargo, String descripcionCargo, String UsuarioAgrega, String ipUsuarioAgrega, Date fechaAgrega) {
        this.codigoCargo = codigoCargo;
        this.nombreCargo = nombreCargo;
        this.descripcionCargo = descripcionCargo;
        this.UsuarioAgrega = UsuarioAgrega;
        this.ipUsuarioAgrega = ipUsuarioAgrega;
        this.fechaAgrega = fechaAgrega;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_queja", unique = true, nullable = false)
    public Long getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Long codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    @Column(name = "nombre_region")
    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @Column(name = "descripcion_cargo")
    public String getDescripcionCargo() {
        return descripcionCargo;
    }
    
    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    @Column(name = "usuario_agrega")
    public String getUsuarioAgrega() {
        return UsuarioAgrega;
    }

    public void setUsuarioAgrega(String UsuarioAgrega) {
        this.UsuarioAgrega = UsuarioAgrega;
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
