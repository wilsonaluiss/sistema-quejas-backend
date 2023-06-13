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
@Table(name = "quejas", schema = "")
public class SqQuejas implements java.io.Serializable {

    private Long codigoQueja;
    private Integer codigoEtapa;
    private Integer codigoRegion;
    private Integer codigoTipoCreador;
    private Integer codigoMedioIngreso;
    private Integer codigoEstadoExterno;
    private Integer codigoEstadoInterno;
    private Integer codigoTipoQueja;
    private Integer codigoPuntoAtencion;
    private String dpiUsuario;
    private String nombre;
    private String correoElectronico;
    private String nombreEmpleado;
    private String detalleQueja;
    private String correlativo;
    private String documentoSoporte;
    private String justificacion;
    private Integer anioQueja;
    private String oficina;
    private String usuarioAgrega;
    private String usuarioModifica;
    private Date fechaAgrega;
    private Date fechaModifica;

    public SqQuejas() {
    }

    public SqQuejas(Long codigoQueja, Integer codigoEtapa, Integer codigoRegion, Integer codigoTipoCreador, Integer codigoMedioIngreso, Integer codigoEstadoExterno, Integer codigoEstadoInterno, Integer codigoTipoQueja, Integer codigoPuntoAtencion, String dpiUsuario, String nombre, String correoElectronico, String nombreEmpleado, String detalleQueja, String correlativo, String documentoSoporte, String justificacion, Integer anioQueja,String oficina, String usuarioAgrega, String usuarioModifica, Date fechaAgrega, Date fechaModifica) {
        this.codigoQueja = codigoQueja;
        this.codigoEtapa = codigoEtapa;
        this.codigoRegion = codigoRegion;
        this.codigoTipoCreador = codigoTipoCreador;
        this.codigoMedioIngreso = codigoMedioIngreso;
        this.codigoEstadoExterno = codigoEstadoExterno;
        this.codigoEstadoInterno = codigoEstadoInterno;
        this.codigoTipoQueja = codigoTipoQueja;
        this.codigoPuntoAtencion = codigoPuntoAtencion;
        this.dpiUsuario = dpiUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.nombreEmpleado = nombreEmpleado;
        this.detalleQueja = detalleQueja;
        this.correlativo = correlativo;
        this.documentoSoporte = documentoSoporte;
        this.justificacion = justificacion;
        this.anioQueja = anioQueja;
        this.oficina = oficina;
        this.usuarioAgrega = usuarioAgrega;
        this.usuarioModifica = usuarioModifica;
        this.fechaAgrega = fechaAgrega;
        this.fechaModifica = fechaModifica;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_queja", unique = true, nullable = false)

    public Long getCodigoQueja() {
        return codigoQueja;
    }

    public void setCodigoQueja(Long codigoQueja) {
        this.codigoQueja = codigoQueja;
    }

    @Column(name = "codigo_etapa")
    public Integer getCodigoEtapa() {
        return codigoEtapa;
    }

    public void setCodigoEtapa(Integer codigoEtapa) {
        this.codigoEtapa = codigoEtapa;
    }

    @Column(name = "codigo_region")
    public Integer getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(Integer codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    @Column(name = "codigo_tipo_creador")
    public Integer getCodigoTipoCreador() {
        return codigoTipoCreador;
    }

    public void setCodigoTipoCreador(Integer codigoTipoCreador) {
        this.codigoTipoCreador = codigoTipoCreador;
    }

    @Column(name = "codigo_medio_ingreso")
    public Integer getCodigoMedioIngreso() {
        return codigoMedioIngreso;
    }

    public void setCodigoMedioIngreso(Integer codigoMedioIngreso) {
        this.codigoMedioIngreso = codigoMedioIngreso;
    }

    @Column(name = "codigo_estado_externo")
    public Integer getCodigoEstadoExterno() {
        return codigoEstadoExterno;
    }

    public void setCodigoEstadoExterno(Integer codigoEstadoExterno) {
        this.codigoEstadoExterno = codigoEstadoExterno;
    }

    @Column(name = "codigo_estado_interno")
    public Integer getCodigoEstadoInterno() {
        return codigoEstadoInterno;
    }

    public void setCodigoEstadoInterno(Integer codigoEstadoInterno) {
        this.codigoEstadoInterno = codigoEstadoInterno;
    }

    @Column(name = "codigo_tipo_queja")
    public Integer getCodigoTipoQueja() {
        return codigoTipoQueja;
    }

    public void setCodigoTipoQueja(Integer codigoTipoQueja) {
        this.codigoTipoQueja = codigoTipoQueja;
    }

    @Column(name = "codigo_punto_atencion")
    public Integer getCodigoPuntoAtencion() {
        return codigoPuntoAtencion;
    }

    public void setCodigoPuntoAtencion(Integer codigoPuntoAtencion) {
        this.codigoPuntoAtencion = codigoPuntoAtencion;
    }

    @Column(name = "dpi_usuario")
    public String getDpiUsuario() {
        return dpiUsuario;
    }

    public void setDpiUsuario(String dpiUsuario) {
        this.dpiUsuario = dpiUsuario;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "correo_electronico")
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Column(name = "nombre_empleado")
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Column(name = "detalle_queja")
    public String getDetalleQueja() {
        return detalleQueja;
    }

    public void setDetalleQueja(String detalleQueja) {
        this.detalleQueja = detalleQueja;
    }

    @Column(name = "correlativo")
    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    @Column(name = "documento_soporte")
    public String getDocumentoSoporte() {
        return documentoSoporte;
    }

    public void setDocumentoSoporte(String documentoSoporte) {
        this.documentoSoporte = documentoSoporte;
    }

    @Column(name = "justificacion")
    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Column(name = "anio_queja")
    public Integer getAnioQueja() {
        return anioQueja;
    }

    public void setAnioQueja(Integer anioQueja) {
        this.anioQueja = anioQueja;
    }

    

    @Column(name = "oficina")
    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }
    
    

    @Column(name = "usuario_agrega")
    public String getUsuarioAgrega() {
        return usuarioAgrega;
    }

    public void setUsuarioAgrega(String usuarioAgrega) {
        this.usuarioAgrega = usuarioAgrega;
    }

    @Column(name = "usuario_modifica")
    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
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
    @Column(name = "fecha_modificacion")
    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
    
    

}
