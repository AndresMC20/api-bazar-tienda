package com.tienda.api_bazar_tienda.controllers;

import com.tienda.api_bazar_tienda.models.Usuario;
import com.tienda.api_bazar_tienda.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    // Devolver la lista de usuarios
    @GetMapping
    public List<Usuario> index(){
        return usuarioService.findAll();
    }


    // Devolver un usuario
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);

        Map<String, Object> response = new HashMap<>();

        if(usuario == null){
            response.put("error", "El usuario no fue encontrado");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }


    // Crear un usuario
    @PostMapping("/crear")
    public ResponseEntity<?> create(@Valid @RequestBody Usuario request, BindingResult result){
        Usuario usuario = null;

        Map<String, Object> response = new HashMap<>();

        //Para los errores de los models
        if(result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for(FieldError err : result.getFieldErrors()){
                errors.add(err.getDefaultMessage());
            }
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Para ver si el usuario ya existe
        if(usuarioService.existsByUsername(request.getUsername())){
            response.put("error", "El username ya existe, intenta con otro username");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Para la comparacion de passwords
        if(!request.getPassword().equals(request.getConfirmationPassword())){
            response.put("error", "El password y la confirmacion no coinciden");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            usuario = usuarioService.save(request);
        }catch (DataAccessException e){
            response.put("error", "El usuario no se pudo crear");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario ha sido creado exitosamente");
        response.put("Usuario", usuario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
