package com.quejas.quejas;

import com.quejas.quejas.modelo.Rol;
import com.quejas.quejas.modelo.Usuario;
import com.quejas.quejas.modelo.UsuarioRol;
import com.quejas.quejas.servicios.UsuarioService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class QuejasApplication implements CommandLineRunner {
    
    

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(QuejasApplication.class, args);
    }
    
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:4200/").allowedMethods("*").allowedHeaders("*");
//
//            }
//        };
//    }

    @Override
    public void run(String... args) throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setNombre("Wilson");
//        usuario.setApellido("Luis");
//        usuario.setUsername("wilson");
//        usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
//        usuario.setEmail("alex@gmail.com");
//        usuario.setTelefono("123456778");
//        usuario.setTipo_usuario(0);
//
//        Rol rol = new Rol();
//        rol.setRolId(1L);
//        rol.setNombre("ADMIN");
//
//        Set<UsuarioRol> usuarioRoles = new HashSet<>();
//        UsuarioRol usuarioRol = new UsuarioRol();
//        usuarioRol.setRol(rol);
//        usuarioRol.setUsuario(usuario);
//        usuarioRoles.add(usuarioRol);
//
//        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
//        System.out.println(usuarioGuardado.getUsername());
   }

}
