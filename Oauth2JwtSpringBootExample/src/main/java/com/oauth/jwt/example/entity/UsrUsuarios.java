/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oauth.jwt.example.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsrUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    /**
     * nombe del usuario.
     */
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    /**
     * contraseña del usuario.
     */
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;

    /**
     * lista de roles asociados al usuario.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns
            = @JoinColumn(name = "id_usuario",
                    referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol",
                    referencedColumnName = "id_rol"))
    private List<UsrRol> roles;
}
