package com.oauth.jwt.example.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jhon
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsrUsuarioDTO {

    /**
     * id del usuario.
     */
    private Integer idUsuario;
    /**
     * nombe del usuario.
     */
    private String nombreUsuario;
    /**
     * lista de roles asociados al usuario.
     */
    private List<UsrRolDTO> roles;
    /**
     * contraseña del usuario.
     */
    private String contrasena;
}
