/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wilson
 */
@Data
@Builder
@AllArgsConstructor
public class SqPuntosAtencionDto {
    
    private Long codigoAtencionId;
    private int regionPatencion;
    private String nombrePatencion;
    private Integer estado;
    private String usuarioAgrega;
    private String ipUsuarioAgrega;
    private Date fechaAgrega;


    public SqPuntosAtencionDto() {
    }
    
    
}
