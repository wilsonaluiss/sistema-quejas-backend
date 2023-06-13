/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.controllers;

import com.quejas.quejas.modelo.JwtRequest;
import com.quejas.quejas.modelo.Rol;
import com.quejas.quejas.modelo.Usuario;
import com.quejas.quejas.modelo.UsuarioRol;
import com.quejas.quejas.servicios.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Wilson
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuariosRoles = new HashSet<>();
        Rol rol = new Rol();
        System.out.println("tipo??" + usuario.getTipo_usuario());
        switch (usuario.getTipo_usuario()) {
            case 5:
                rol.setRolId(5L);
                rol.setNombre("USUARIO");
                break;
            case 6:
                rol.setRolId(6L);
                rol.setNombre("CUENTAHABIENTE");
                break;
            case 4:
                rol.setRolId(4L);
                rol.setNombre("CENTRALIZADOR");
                break;
            case 3:
                rol.setRolId(3L);
                rol.setNombre("OPERADOR");
                break;
            case 7:
                rol.setRolId(7L);
                rol.setNombre("JEFE");
                break;
            default:
        }
//        if (usuario.getTipo_usuario() == 5) {
//            rol.setRolId(5L);
//            rol.setNombre("USUARIO");
//        }
//        if (usuario.getTipo_usuario() == 6) {
//            rol.setRolId(6L);
//            rol.setNombre("CUENTAHABIENTE");
//        } else {
//            rol.setRolId(2L);
//            rol.setNombre("NORMAL");
//        }

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuariosRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario, usuariosRoles);
    }

    @GetMapping("/{username}")
    @Operation(summary = "prueba unitaria :v", description = "holi que hace perro, durmiendo o khe hace")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{UsuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
        usuarioService.eliminarUsuario(usuarioId);
    }
    
}
