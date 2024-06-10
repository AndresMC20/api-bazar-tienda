package com.tienda.api_bazar_tienda.repositories;

import com.tienda.api_bazar_tienda.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
    // Para verificar si ya existe el username
    boolean existsByUsername(String username);
}
