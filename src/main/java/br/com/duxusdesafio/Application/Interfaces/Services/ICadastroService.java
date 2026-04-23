package br.com.duxusdesafio.Application.Interfaces.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.IntegranteInputDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Dto.TimeInputDto;

public interface ICadastroService {
    IntegranteDto cadastrarIntegrante(IntegranteInputDto integranteInput);

    TimeDto cadastrarTime(TimeInputDto timeInput);

    IntegranteDto atualizarIntegrante(long id, IntegranteInputDto integranteInput);

    void deletarIntegrante(long id);

    TimeDto atualizarTime(long id, TimeInputDto timeInput);

    void deletarTime(long id);

    TimeDto buscarTimePorId(long id);

    Page<TimeDto> listarTimes(Pageable pageable);

    java.util.List<IntegranteDto> listarIntegrantesSemTimes();
}
