package br.com.duxusdesafio.Application.Interfaces.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.duxusdesafio.Domain.Entity.Integrante;

public interface IIntegranteRepository extends JpaRepository<Integrante, Long> {
    List<Integrante> findByComposicaoTimeIsEmpty();
}
