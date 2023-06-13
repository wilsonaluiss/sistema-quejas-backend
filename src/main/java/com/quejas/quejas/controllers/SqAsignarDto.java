/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Wilson
 */
@Data
public class SqAsignarDto {

    private List<Long> solicitud;
    private int complemento;
    private String justificacion;

}
