package com.example.demo;

import dto.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GestionUsuario {
    @GetMapping("/getUsuario")
    public ResponseEntity<Usuario> getUsuario(){
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(usuario);
        }
    }
    @PostMapping("/postUsuario")
    public boolean setUsuario(@RequestParam String nickname, @RequestParam String password){
        boolean mayusculas = false;
        boolean minusculas = false;
        boolean letras = false;
        boolean numero = false;

        for (char character : password.toCharArray()) {
            if (Character.isDigit(character)) {
                numero = true;
            }
            if (Character.isLetter(character)) {
                letras = true;
            }
            if(Character.isUpperCase(character)){
                mayusculas = true;
            }
            if (Character.isLowerCase(character)) {
                minusculas = true;
            }
        }
        if (password.length() > 8 && mayusculas && minusculas && letras && numero) {
            usuario = new Usuario(nickname, password);
            return true;
        }else {
            return false;
        }
    }
}
