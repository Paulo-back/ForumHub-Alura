package br.com.paulo.ForumHub.Controller;

import br.com.paulo.ForumHub.Domain.Curso.Curso;
import br.com.paulo.ForumHub.Domain.Curso.CursoRepository;
import br.com.paulo.ForumHub.Domain.Curso.DadosCadastroCurso;
import br.com.paulo.ForumHub.Domain.Curso.DadosDetalhamentoCurso;
import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Topicos.DadosDetalhamentoTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("curso")
public class CursoController {
    @Autowired
    private CursoRepository repository;

    @RequestMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastroLivro(@RequestBody @Valid DadosCadastroCurso dados){
        var curso = new Curso(dados);
        repository.save(curso);
        return ResponseEntity.ok("Livro cadastrado Com Sucesso!");


    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DadosDetalhamentoCurso>> listar(Pageable pageable){
        var curso = repository.findAll(pageable).map(DadosDetalhamentoCurso::new);

        return ResponseEntity.ok(curso);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<DadosDetalhamentoCurso>listarPorId(@PathVariable Long id){
        var curso = repository.findById(id);
        if (curso.isPresent()){
            return ResponseEntity.ok(new DadosDetalhamentoCurso(curso.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity excluirCurso(@PathVariable Long id){
        var curso = repository.findById(id);
        if (curso.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok().body("Curso excluido com sucesso!");
        }else {
            return ResponseEntity.badRequest().body("Curso não encontrado, id incorreto!");
        }
    }




}
