package com.oauth.jwt.example.services;


import com.oauth.jwt.example.dto.UsrUsuarioDTO;
import java.util.List;

public interface UsrUsuariosService {

    /**
     * metodo para eliminar un usuario de la base ded datos.
     *
     * @param id del usuario
     * @return objeto de tipo usuarioDTO que fue eliminado de la base de datos
     */
    UsrUsuarioDTO eliminarUsuraio(Integer id);

    /**
     * metodo para listar a todos los usuarios de la base de datos.
     *
     * @return lista de usuarios almacenados en la base de datos
     */
    List<UsrUsuarioDTO> listarTodos();

}
