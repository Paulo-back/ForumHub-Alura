package br.com.paulo.ForumHub.Domain.Respostas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RespostasRepository extends JpaRepository<Respostas, Long> {
    @Query("SELECT r FROM Respostas r WHERE r.id = :id AND r.solucao = false")
    Optional<Respostas> buscarPorIdEStatusFalse(@Param("id") Long id);
}
