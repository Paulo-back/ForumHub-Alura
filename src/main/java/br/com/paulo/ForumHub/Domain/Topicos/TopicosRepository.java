package br.com.paulo.ForumHub.Domain.Topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicosRepository extends JpaRepository<Topicos, Long> {

    boolean existsByTituloAndMensagem(String titulo, String mensagem);


    Page<Topicos> findAllByStatusFalse(Pageable paginacao);

    @Query("SELECT t FROM Topicos t WHERE t.id = :id AND t.status = false")
    Optional<Topicos> buscarPorIdEStatusFalse(@Param("id") Long id);

}
