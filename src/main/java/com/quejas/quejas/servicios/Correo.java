/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilson
 */
@Service
public class Correo {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() throws MessagingException {
        //List<Persona> cc = envioRepository.findAll();//new ArrayList(); Lista para llenar obtener los datos de Persona
        //for (int i =0; i<cc.size(); i++){
//        SimpleMailMessage email = new SimpleMailMessage();
//
//        email.setTo("unleashed123456@gmail.com");//obtiene los datos de todos los correos en DB
//        email.setSubject("Prueba");//Titulo
//        email.setText("Correos de prueba");//Cuerpo
//        mailSender.send(email);//envio de correos
        // }

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("mail.host.com");

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("unleashed123456@gmail.com");
        helper.setTo("unleashed123456@gmail.com");
        helper.setText("Thank you!");
        sender.send(message);
    }
}
