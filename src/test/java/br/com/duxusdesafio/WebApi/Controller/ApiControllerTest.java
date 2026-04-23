package br.com.duxusdesafio.WebApi.Controller;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Interfaces.Services.IApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IApiService service;

    @Test
    public void shouldReturnTimeDaData() throws Exception {
        TimeDto timeDto = new TimeDto(1L, "Falcons", LocalDate.of(2021, 1, 15), Collections.emptyList());
        Mockito.when(service.timeDaData(LocalDate.of(2021, 1, 15))).thenReturn(timeDto);

        mockMvc.perform(get("/api/time").param("data", "2021-01-15"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(timeDto)));
    }

}
