package br.com.paulo.ForumHub.Controller;

import br.com.paulo.ForumHub.Domain.Respostas.DadosCadastroResposta;
import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Respostas.RespostasRepository;
import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import br.com.paulo.ForumHub.Domain.Topicos.TopicosRepository;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import br.com.paulo.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RespostaController {
    private RespostasRepository respostasRepository;
    private UsuarioRepository usuarioRepository;
    private TopicosRepository topicosRepository;


    @PostMapping("/respostas/cadastrar")
    @Transactional
    public void cadastrarResposta(@RequestBody @Valid DadosCadastroResposta dados) {

        Usuario autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Topicos topico = topicosRepository.findById(dados.topicoId())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        Respostas resposta = new Respostas(dados, autor, topico);

        respostasRepository.save(resposta);

        System.out.println("Resposta salva para o tópico: " + topico.getTitulo());
    }
}
