/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.projections;

import java.util.Date;

/**
 *
 * @author Wilson
 */
public interface SqCentralizadorProjection {
    
    Long getCodigoQueja();
    String getCorrelativo();
    Date getFechaHora();
    Integer getCodigoEtapa();
    String getDetalleQueja();
    
}
