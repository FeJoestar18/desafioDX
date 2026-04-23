package br.com.duxusdesafio.WebApi.Controller;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.IntegranteInputDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Dto.TimeInputDto;
import br.com.duxusdesafio.Application.Interfaces.Services.ICadastroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Cadastro de Times")
@RestController
@RequestMapping("/api")
public class CadastroController {

    private final ICadastroService service;

    public CadastroController(ICadastroService service) {
        this.service = service;
    }

    @ApiOperation("Cadastra um novo integrante")
    @PostMapping("/integrantes")
    public IntegranteDto cadastrarIntegrante(@RequestBody IntegranteInputDto integranteInput) {
        return service.cadastrarIntegrante(integranteInput);
    }

    @ApiOperation("Cadastra um novo time com integrantes")
    @PostMapping("/times")
    public TimeDto cadastrarTime(@RequestBody TimeInputDto timeInput) {
        return service.cadastrarTime(timeInput);
    }
}
