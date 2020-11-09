/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oauth.jwt.example.controller;


import com.oauth.jwt.example.services.UsrUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhon
 */
@RestController
@RequestMapping("/api/v.1/usuarios")
public class UsrUsuarioController {

    /**
     * usuarios service.
     */
    @Autowired
    private UsrUsuariosService usrUsuariosService;


    /**
     * metodo para eliminar un usuario de la base de datos.
     *
     * @param id del usuario
     * @return objeto eliminado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usrUsuariosService.eliminarUsuraio(id));
    }

    /**
     * metodo para listar todos los usuario de la base de datos.
     *
     * @return lista de usuarios guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(usrUsuariosService.listarTodos());
    }
}
