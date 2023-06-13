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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilson
 */
@Entity
@Builder
@RestController
@Table(name = "tipos_quejas", schema = "")
public class SqTipoQuejas implements java.io.Serializable {
    
    private Long codigoTipoQueja;
    private int codigoEstado;
    private String siglas;
    private String descripcionTipoQueja;
    private String usuarioAgrega;
    private String ipUsuarioAgrega;
    private Date fechaAgrega;
    private Date fechaModifica;

    public SqTipoQuejas() {
    }

    public SqTipoQuejas(Long codigoTipoQueja, int codigoEstado, String siglas, String descripcionTipoQueja, String usuarioAgrega, String ipUsuarioAgrega, Date fechaAgrega, Date fechaModifica) {
        this.codigoTipoQueja = codigoTipoQueja;
        this.codigoEstado = codigoEstado;
        this.siglas = siglas;
        this.descripcionTipoQueja = descripcionTipoQueja;
        this.ipUsuarioAgrega = ipUsuarioAgrega;
        this.usuarioAgrega = usuarioAgrega;
        this.fechaAgrega = fechaAgrega;
        this.fechaModifica = fechaModifica;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipo_queja", unique = true, nullable = false)

    public Long getCodigoTipoQueja() {
        return codigoTipoQueja;
    }

    public void setCodigoTipoQueja(Long codigoTipoQueja) {
        this.codigoTipoQueja = codigoTipoQueja;
    }

    @Column(name = "codigo_estado")
    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    @Column(name = "siglas")
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Column(name = "descripcion_tipo_queja")
    public String getDescripcionTipoQueja() {
        return descripcionTipoQueja;
    }

    public void setDescripcionTipoQueja(String descripcionTipoQueja) {
        this.descripcionTipoQueja = descripcionTipoQueja;
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


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modifica")
    public Date getFechaModifica() {
        return fechaModifica;
    }

    
    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
    
    
}
