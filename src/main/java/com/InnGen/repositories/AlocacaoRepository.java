package com.InnGen.repositories;

import com.InnGen.models.Alocacao;
import com.InnGen.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {
}