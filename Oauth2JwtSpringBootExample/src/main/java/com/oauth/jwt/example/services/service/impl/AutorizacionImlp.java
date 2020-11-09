package com.oauth.jwt.example.services.service.impl;

import com.oauth.jwt.example.entity.UsrUsuarios;
import com.oauth.jwt.example.exceptions.responses.BadRequestException;
import com.oauth.jwt.example.repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

@Service(value = "userService")
public class AutorizacionImlp implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UsrUsuarios usu = usuarioRepository.findByNombreUsuario(userId);

        if (usu != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            usu.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getNombre()));
            });
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(usu.getNombreUsuario(), usu.getContrasena(), authorities);
            return userDetails;
        }
        throw new BadRequestException("El usuario no existe");
    }
}
