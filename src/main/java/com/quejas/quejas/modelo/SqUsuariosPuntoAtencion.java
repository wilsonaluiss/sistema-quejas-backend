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
@Table(name = "usuarios_puntos_atencion", schema = "")
public class SqUsuariosPuntoAtencion implements java.io.Serializable {
    
    private Long codigoUsuarioPunto;
    private String nombreUsuarioAtencion;
    private int regionPatencion;
    private int codigoEstado;
    private int codigoPuntoAtencion;
    private String dpiUsuario;
    private int codigoCargo;
    private String CorreoElectronico;
    private String UsuarioAgrega;
    private String ipUsuarioAgrega;
    private Date fechaAgrega;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public SqUsuariosPuntoAtencion() {
    }

    public SqUsuariosPuntoAtencion(Long codigoUsuarioPunto, String nombreUsuarioAtencion, int regionPatencion, int codigoEstado, int codigoPuntoAtencion, String dpiUsuario, int codigoCargo, String CorreoElectronico, String UsuarioAgrega, String ipUsuarioAgrega, Date fechaAgrega, Date fechaCreacion, Date fechaModificacion) {
        this.codigoUsuarioPunto = codigoUsuarioPunto;
        this.nombreUsuarioAtencion = nombreUsuarioAtencion;
        this.regionPatencion = regionPatencion;
        this.codigoEstado = codigoEstado;
        this.codigoPuntoAtencion = codigoPuntoAtencion;
        this.dpiUsuario = dpiUsuario;
        this.codigoCargo = codigoCargo;
        this.CorreoElectronico = CorreoElectronico;
        this.UsuarioAgrega = UsuarioAgrega;
        this.ipUsuarioAgrega = ipUsuarioAgrega;
        this.fechaAgrega = fechaAgrega;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario_punto", unique = true, nullable = false)
    public Long getCodigoUsuarioPunto() {
        return codigoUsuarioPunto;
    }

    public void setCodigoUsuarioPunto(Long codigoUsuarioPunto) {
        this.codigoUsuarioPunto = codigoUsuarioPunto;
    }

    @Column(name = "nombre_usuario_atencion")
    public String getNombreUsuarioAtencion() {
        return nombreUsuarioAtencion;
    }

    public void setNombreUsuarioAtencion(String nombreUsuarioAtencion) {
        this.nombreUsuarioAtencion = nombreUsuarioAtencion;
    }

    @Column(name = "region_patencion")
    public int getRegionPatencion() {
        return regionPatencion;
    }

    public void setRegionPatencion(int regionPatencion) {
        this.regionPatencion = regionPatencion;
    }
    

    @Column(name = "codigo_estado")
    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    @Column(name = "codigo_punto_atencion")
    public int getCodigoPuntoAtencion() {
        return codigoPuntoAtencion;
    }

    public void setCodigoPuntoAtencion(int codigoPuntoAtencion) {
        this.codigoPuntoAtencion = codigoPuntoAtencion;
    }
    

    @Column(name = "dpi_usuario")
    public String getDpiUsuario() {
        return dpiUsuario;
    }

    public void setDpiUsuario(String dpiUsuario) {
        this.dpiUsuario = dpiUsuario;
    }

    @Column(name = "codigo_cargo")
    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    @Column(name = "correo_electronico")
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
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

    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    
    
}
