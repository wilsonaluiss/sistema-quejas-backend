/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.servicios.Correo;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilson
 */
@Api
@RestController
@Slf4j
@RequestMapping("/correos")
@CrossOrigin("*")
public class CorreosController {

    @Autowired
    Correo correo;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping(path = "/envioCorreos")
    @Operation(summary = "Envia correos", description = "Envia correos")
    public ResponseEntity<?> correo() {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("wilsonaluiss@gmail.com");
        email.setFrom("bancoprestamito@gmail.com");
        email.setSubject("probando perro");
        email.setText("Holi xd te llego el correo?");
        mailSender.send(email);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
