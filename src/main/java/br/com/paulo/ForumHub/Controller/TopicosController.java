package br.com.paulo.ForumHub.Controller;

import br.com.paulo.ForumHub.Domain.Curso.Curso;
import br.com.paulo.ForumHub.Domain.Curso.CursoRepository;
import br.com.paulo.ForumHub.Domain.Topicos.DadosCadastroTopico;
import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import br.com.paulo.ForumHub.Domain.Topicos.TopicosRepository;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import br.com.paulo.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    private TopicosRepository repository;
    private UsuarioRepository usuarioRepository;
    private CursoRepository cursoRepository;

    @RequestMapping("/cadastrar")
    @Transactional
    public void cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados){
        Usuario autor = usuarioRepository.findById(dados.autor_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Curso curso = cursoRepository.findById(dados.curso_id())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Topicos topico = new Topicos(dados, autor, curso);

        repository.save(topico);

        System.out.println("Tópico salvo: " + topico.getTitulo());

    }
}




//@PostMapping("/cadastrar")
//@Transactional
//public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
//    var medico = new Medico(null,dados);
//    repository.save(medico);
//
//    var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
//    System.out.println(dados);
//    return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
//
//}