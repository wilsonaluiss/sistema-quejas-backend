/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.dtos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@NoArgsConstructor
@Entity
public class FiltrosDto implements Serializable {
    
    @Id
    private Long codigoQueja;
    private int codigoEtapa;
    private int codigoEstadoExterno;
    private int codigoEstadoInterno;
    private int anioQueja;
    private String correlativo;
    
    
}
