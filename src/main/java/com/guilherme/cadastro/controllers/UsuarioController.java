package com.guilherme.cadastro.controllers;

import com.guilherme.cadastro.models.Usuario;
import com.guilherme.cadastro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario criaUsuario(@RequestBody Usuario usuario) throws Exception {
        Optional<Usuario> usuarioOptional = repository.findById(usuario.getCpfOuCnpj());

        if(usuarioOptional.isPresent()) {
            throw new Exception("Usuário já cadastrado");
        }
        return repository.save(usuario);

    }

    @PutMapping
    public Usuario atualizaUsuario(@RequestBody Usuario usuarioUpdate) throws Exception {
        Optional<Usuario> usuarioOptional = repository.findById(usuarioUpdate.getCpfOuCnpj());

        if(usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioUpdate.getNome());
            return repository.save(usuario);
        }

        throw new Exception("Usuário não encontrado");
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    @DeleteMapping("/{cpfOuCnpj}")
    public void deletaUsuarioPorCpfOuCnpj(@PathVariable("cpfOuCnpj") String cpfOuCnpj) throws Exception {
        Usuario usuario = repository.findById(cpfOuCnpj).orElseThrow(() -> new Exception("Usuário não encontrado"));

        repository.delete(usuario);
    }

    @GetMapping("/{cpfOuCnpj}")
    public Usuario buscaUsuarioPorCpfOuCnpj(@PathVariable("cpfOuCnpj") String cpfOuCnpj) throws Exception {
        return repository.findById(cpfOuCnpj).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
}
