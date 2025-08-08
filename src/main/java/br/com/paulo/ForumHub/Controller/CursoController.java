package br.com.paulo.ForumHub.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Curso")
public class CursoController {

}




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