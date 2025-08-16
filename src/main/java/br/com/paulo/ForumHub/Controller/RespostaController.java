package br.com.paulo.ForumHub.Controller;

import br.com.paulo.ForumHub.Domain.Respostas.DadosCadastroResposta;
import br.com.paulo.ForumHub.Domain.Respostas.DadosDetalhamentoResposta;
import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Respostas.RespostasRepository;
import br.com.paulo.ForumHub.Domain.Topicos.DadosDetalhamentoTopico;
import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import br.com.paulo.ForumHub.Domain.Topicos.TopicosRepository;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import br.com.paulo.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("respostas")
public class RespostaController {
    @Autowired
    private RespostasRepository respostasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicosRepository topicosRepository;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrarResposta(@RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuild) {

        Usuario autor = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Topicos topico = topicosRepository.findById(dados.topicoId())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        Respostas resposta = new Respostas(dados, autor, topico);

        respostasRepository.save(resposta);
//        System.out.println("Resposta salva para o tópico: " + topico.getTitulo());
        var uri = uriBuild.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoResposta(resposta));


    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DadosDetalhamentoResposta>> listar(Pageable pageable){
        var respostas = respostasRepository.findAll(pageable).map(DadosDetalhamentoResposta::new);
        return ResponseEntity.ok(respostas);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<DadosDetalhamentoResposta> listarPorId(@PathVariable Long id){
        var respotas = respostasRepository.buscarPorIdEStatusFalse(id);
        if (respotas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DadosDetalhamentoResposta(respotas.get()));
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluirResposta(@PathVariable Long id){
        var respostas = respostasRepository.findById(id);
        if (respostas.isPresent()){
            respostasRepository.deleteById(id);
            return ResponseEntity.ok("Exclusão feita com sucesso!");
        }else {
            return ResponseEntity.badRequest().body("Id do tópico não existe!");
        }

    }
}
