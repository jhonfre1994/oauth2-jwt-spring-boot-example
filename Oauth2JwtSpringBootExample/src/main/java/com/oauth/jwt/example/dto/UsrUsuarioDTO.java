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

    private Integer idUsuario;
    private String nombreUsuario;
    private List<UsrRolDTO> roles;
    private String contrasena;
    private String nombres;
    private String apellidos;
}
