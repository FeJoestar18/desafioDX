package br.com.duxusdesafio.Service;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.IntegranteInputDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Dto.TimeInputDto;
import br.com.duxusdesafio.Application.Interfaces.Services.ICadastroService;
import br.com.duxusdesafio.Application.Interfaces.Services.IApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class ApiServiceIntegrationTest {

    @Autowired
    private ICadastroService cadastroService;

    @Autowired
    private IApiService apiService;

    @Test
    public void shouldPersistIntegranteAndTimeWithH2() {
        IntegranteInputDto integranteInput = new IntegranteInputDto("Test Player", "Atacante");
        IntegranteDto integranteCriado = cadastroService.cadastrarIntegrante(integranteInput);

        assertNotNull(integranteCriado.getId());
        assertEquals("Test Player", integranteCriado.getNome());

        TimeInputDto timeInput = new TimeInputDto("Test Club", LocalDate.of(2023, 1, 1),
                List.of(integranteCriado.getId()));
        TimeDto timeCriado = cadastroService.cadastrarTime(timeInput);

        assertNotNull(timeCriado);
        assertEquals("Test Club", timeCriado.getNomeDoClube());
        assertEquals(LocalDate.of(2023, 1, 1), timeCriado.getData());
        assertEquals(1, timeCriado.getIntegrantes().size());

        TimeDto timeEncontrado = apiService.timeDaData(LocalDate.of(2023, 1, 1));
        assertEquals("Test Club", timeEncontrado.getNomeDoClube());
    }
}
