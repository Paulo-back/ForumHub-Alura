package br.com.paulo.ForumHub.Controller;


import br.com.paulo.ForumHub.Domain.Usuario.DadosCadastro;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import br.com.paulo.ForumHub.Domain.Usuario.UsuarioRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    //ResponseEntity depois
    public void cadastrar(@RequestBody @Valid DadosCadastro dados){
        System.out.println("Dados Recebidos:\n" + dados);
        var usuario = new Usuario(dados);
//        repository.save(dados);

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



//@RestController
//@RequestMapping("consultas")
//@SecurityRequirement(name = "bearer-key")
//public class ConsultaController {
//    @Autowired
//    private AgendaDeConsulta agenda;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
//        System.out.println(dados);
//        var dto = agenda.agendar(dados);
//        return ResponseEntity.ok(dto);
//    }
//
//    @DeleteMapping
//    @Transactional
//    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
//        agenda.cancelar(dados);
//        return ResponseEntity.noContent().build();
//    }
//
//}
