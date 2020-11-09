package com.oauth.jwt.example.repository;

import com.oauth.jwt.example.entity.UsrUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsrUsuarios, Integer> {
    
    UsrUsuarios findByNombreUsuario(String nombreUsuario);

}
