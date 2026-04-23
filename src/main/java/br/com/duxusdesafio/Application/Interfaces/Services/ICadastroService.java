package br.com.duxusdesafio.Application.Interfaces.Services;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.IntegranteInputDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Dto.TimeInputDto;

public interface ICadastroService {
    IntegranteDto cadastrarIntegrante(IntegranteInputDto integranteInput);

    TimeDto cadastrarTime(TimeInputDto timeInput);
}
