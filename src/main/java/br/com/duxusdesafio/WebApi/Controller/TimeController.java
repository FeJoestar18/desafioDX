package br.com.duxusdesafio.WebApi.Controller;

import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Interfaces.Services.ICadastroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Times")
@RestController
@RequestMapping("/api")
public class TimeController {

    private final ICadastroService service;

    public TimeController(ICadastroService service) {
        this.service = service;
    }

    @ApiOperation("Listar times com integrantes paginado")
    @GetMapping("/times")
    public Page<TimeDto> listarTimes(Pageable pageable) {
        return service.listarTimes(pageable);
    }

    @ApiOperation("Buscar time por id com seus integrantes")
    @GetMapping("/times/{id}")
    public TimeDto buscarTimePorId(@PathVariable long id) {
        return service.buscarTimePorId(id);
    }
}
