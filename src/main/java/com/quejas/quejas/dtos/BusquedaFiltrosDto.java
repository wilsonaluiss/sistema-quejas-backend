/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.dtos;

import com.quejas.quejas.servicios.Utils.ReportesUtils.Column;





/**
 *
 * @author Wilson
 */
public class BusquedaFiltrosDto {
    private Integer anioQueja;
    private String correlativo;
    private Long codigoQueja;

    public BusquedaFiltrosDto() {
    }

    public BusquedaFiltrosDto(Integer anioQueja, String correlativo, Long codigoQueja) {
        this.anioQueja = anioQueja;
        this.correlativo = correlativo;
        this.codigoQueja = codigoQueja;
    }
    
    
    @Column(name = "codigo_queja", table = "q")
    public Long getCodigoQueja() {
        return codigoQueja;
    }

    public void setCodigoQueja(Long codigoQueja) {
        this.codigoQueja = codigoQueja;
    }
    
    @Column(name = "anio_queja", table = "q")
    public Integer getAnioQueja() {
        return anioQueja;
    }

    public void setAnioQueja(Integer anioQueja) {
        this.anioQueja = anioQueja;
    }

    @Column(name = "correlativo", table = "q", operator = "ILIKE")
    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }


    @Override
    public String toString() {
        return "BusquedaFiltrosDto{" + "anioQueja=" + anioQueja + ", correlativo=" + correlativo + ", codigoQueja=" + codigoQueja + '}';
    }
    
    
    
    
}
