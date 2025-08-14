package br.com.paulo.ForumHub.Controller;

import br.com.paulo.ForumHub.Domain.Curso.Curso;
import br.com.paulo.ForumHub.Domain.Curso.CursoRepository;
import br.com.paulo.ForumHub.Domain.Topicos.*;
import br.com.paulo.ForumHub.Domain.Usuario.DadosCadastro;
import br.com.paulo.ForumHub.Domain.Usuario.DadosListagemUsuario;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import br.com.paulo.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicosController {
    @Autowired
    private TopicosRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @RequestMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados){
        Usuario autor = usuarioRepository.findById(dados.autor_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Curso curso = cursoRepository.findById(dados.curso_id())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())){
            throw new RuntimeException("Tópico com o mesmo titulo e mensagem já existe!");
        }

        Topicos topico = new Topicos(dados, autor, curso);

        repository.save(topico);
        return  ResponseEntity.ok("Tópico salvo com sucesso!");

//        System.out.println("Tópico salvo: " + topico.getTitulo());

    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listar(Pageable pageable){
//        var topicos = repository.findAll(pageable).map(DadosDetalhamentoTopico::new);
        var topi = repository.findAllByStatusFalse(pageable).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(topi);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> listarPorId(@PathVariable Long id){
        var topicos = repository.buscarPorIdEStatusFalse(id);
        if (topicos.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topicos.get()));
    }
    @PutMapping("/editar/{id}")
    @Transactional
    public ResponseEntity<String> editarTopico(@PathVariable Long id,
                                               @Valid @RequestBody DadosAtualizacaoTopico dados) {
        var optionalTopico = repository.findById(id);
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var topico = optionalTopico.get();

        if (!topico.getAutor().getId().equals(dados.autorId())) {
            return ResponseEntity.status(403).body("Você não tem permissão para alterar este tópico!");
        }

        if (dados.confirmacao() != null && "ok".equalsIgnoreCase(dados.confirmacao().trim()) &&
                dados.titulo() == null && dados.mensagem() == null) {
            if (Boolean.TRUE.equals(topico.getStatus())) {
                return ResponseEntity.badRequest().body("O tópico já está como concluído.");
            }
        }

        dados.aplicarNo(topico);
        repository.save(topico);

        return ResponseEntity.ok("Tópico atualizado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluirDados(@PathVariable Long id){
        var topicos = repository.findById(id);
        if (topicos.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("Exclusão feita com sucesso!");
        }else {
            return ResponseEntity.badRequest().body("Id do tópico não existe!");
        }

    }

}

