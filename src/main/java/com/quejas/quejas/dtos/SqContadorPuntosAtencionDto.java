/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Wilson
 */
@Data
@Builder
@AllArgsConstructor
public class SqContadorPuntosAtencionDto {
    
    private Long codigoAtentcionId;
    private Integer contador;

    public SqContadorPuntosAtencionDto() {
    }
    
    
}
