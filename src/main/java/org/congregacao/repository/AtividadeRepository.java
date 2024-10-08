package org.congregacao.repository;

import org.congregacao.model.Atividade;
import org.congregacao.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>, JpaSpecificationExecutor<Atividade> {

    List<Atividade> findByPessoaAndAnoMes(Pessoa pessoa, String anoMes);

    @Query("SELECT a.anoMes, COUNT(a.participouPregacao) FROM Atividade a WHERE a.participouPregacao = true GROUP BY a.anoMes")
    List<Object[]> countParticipacaoPregacaoPorMes();

}
