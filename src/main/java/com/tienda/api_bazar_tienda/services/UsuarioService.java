package com.tienda.api_bazar_tienda.services;

import com.tienda.api_bazar_tienda.models.Usuario;
import com.tienda.api_bazar_tienda.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Devolver la lista de usuarios
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    // Devolver un usuario
    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    // Guardar o actualizar un usuario
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    // Borrar un usuario
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    // Verificar si existe un username
    public boolean existsByUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

}
