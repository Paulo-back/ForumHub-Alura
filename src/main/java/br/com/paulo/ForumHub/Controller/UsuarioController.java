package br.com.paulo.ForumHub.Controller;


import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Usuario.DadosCadastro;
import br.com.paulo.ForumHub.Domain.Usuario.DadosListagemUsuario;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import br.com.paulo.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastro")
    @Transactional
    //ResponseEntity depois
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastro dados){
//        System.out.println("Dados Recebidos:\n" + dados);
        var usuario = new Usuario(dados);
        System.out.println("usuario: " + usuario);
        repository.save(usuario);
        return ResponseEntity.ok("cadastro efetuado");

    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DadosListagemUsuario>> listarUsuarios(Pageable page){
         Page<DadosListagemUsuario> usuarios = repository.findAll(page).map(DadosListagemUsuario::new);
//        System.out.println(usuarios);
        return ResponseEntity.ok(usuarios);

    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id){
        var usuario = repository.findById(id);
        if (usuario.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok().body("Conta excluida Com Sucesso!");
        }else {
            return ResponseEntity.badRequest().body("Id da conta não encontrado");
        }
    }



}


