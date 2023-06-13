/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quejas.quejas.repository;

import com.quejas.quejas.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wilson
 */
public interface UsuarioRepository extends CrudRepository <Usuario, Long> {
    
    public Usuario findByUsername(String username);
    
}
