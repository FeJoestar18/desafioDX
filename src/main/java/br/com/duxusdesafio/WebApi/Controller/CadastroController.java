package br.com.duxusdesafio.WebApi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.IntegranteInputDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Dto.TimeInputDto;
import br.com.duxusdesafio.Application.Interfaces.Services.ICadastroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

    @ApiOperation("Atualiza um integrante existente")
    @PutMapping("/integrantes/{id}")
    public IntegranteDto atualizarIntegrante(@PathVariable long id,
                                             @RequestBody IntegranteInputDto integranteInput) {
        return service.atualizarIntegrante(id, integranteInput);
    }

    @ApiOperation("Remove um integrante")
    @DeleteMapping("/integrantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarIntegrante(@PathVariable long id) {
        service.deletarIntegrante(id);
    }

    @ApiOperation("Lista integrantes que não fazem parte de nenhum time")
    @GetMapping("/integrantes/sem-times")
    public java.util.List<IntegranteDto> listarIntegrantesSemTimes() {
        return service.listarIntegrantesSemTimes();
    }

    @ApiOperation("Cadastra um novo time com integrantes")
    @PostMapping("/times")
    public TimeDto cadastrarTime(@RequestBody TimeInputDto timeInput) {
        return service.cadastrarTime(timeInput);
    }

    @ApiOperation("Atualiza um time existente")
    @PutMapping("/times/{id}")
    public TimeDto atualizarTime(@PathVariable long id,
                                 @RequestBody TimeInputDto timeInput) {
        return service.atualizarTime(id, timeInput);
    }

    @ApiOperation("Remove um time")
    @DeleteMapping("/times/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTime(@PathVariable long id) {
        service.deletarTime(id);
    }
}
