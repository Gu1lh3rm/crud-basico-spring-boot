package com.guilherme.cadastro.controllers;

import com.guilherme.cadastro.models.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public Usuario criaUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);

        return usuario;
    }

    @PutMapping
    public Usuario atualizaUsuario(@RequestBody Usuario usuarioUpdate) throws Exception {

        for(Usuario usuario : usuarios) {
            if(usuario.getCpfOuCnpj().equals(usuarioUpdate.getCpfOuCnpj())) {
                usuario.setNome(usuarioUpdate.getNome());
                return usuario;
            }
        }

        throw new Exception("Usuário não encontrado");
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @DeleteMapping("/{cpfOuCnpj}")
    public void deletaUsuarioPorCpfOuCnpj(@PathVariable("cpfOuCnpj") String cpfOuCnpj) throws Exception {
        for(Usuario usuario : usuarios) {
            if(usuario.getCpfOuCnpj().equals(cpfOuCnpj)) {
                this.usuarios.remove(usuario);
                return;
            }
        }
        throw new Exception("Usuário não encontrado");
    }

    @GetMapping("/{cpfOuCnpj}")
    public Usuario buscaUsuarioPorCpfOuCnpj(@PathVariable("cpfOuCnpj") String cpfOuCnpj) throws Exception {
        for(Usuario usuario : usuarios) {
            if(usuario.getCpfOuCnpj().equals(cpfOuCnpj)) {
                return usuario;
            }
        }
        throw new Exception("Usuário não encontrado");
    }
}
