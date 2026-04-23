package br.com.duxusdesafio.Infrastructure.Service;

import br.com.duxusdesafio.Application.Dto.IntegranteDto;
import br.com.duxusdesafio.Application.Dto.IntegranteInputDto;
import br.com.duxusdesafio.Application.Dto.TimeDto;
import br.com.duxusdesafio.Application.Dto.TimeInputDto;
import br.com.duxusdesafio.Application.Interfaces.Repository.IComposicaoTimeRepository;
import br.com.duxusdesafio.Application.Interfaces.Repository.IIntegranteRepository;
import br.com.duxusdesafio.Application.Interfaces.Repository.ITimeRepository;
import br.com.duxusdesafio.Application.Interfaces.Services.ICadastroService;
import br.com.duxusdesafio.Domain.Entity.ComposicaoTime;
import br.com.duxusdesafio.Domain.Entity.Integrante;
import br.com.duxusdesafio.Domain.Entity.Time;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CadastroService implements ICadastroService {

    private final ITimeRepository timeRepository;
    private final IIntegranteRepository integranteRepository;
    private final IComposicaoTimeRepository composicaoTimeRepository;

    public CadastroService(
            ITimeRepository timeRepository,
            IIntegranteRepository integranteRepository,
            IComposicaoTimeRepository composicaoTimeRepository) {
        this.timeRepository = timeRepository;
        this.integranteRepository = integranteRepository;
        this.composicaoTimeRepository = composicaoTimeRepository;
    }

    @Override
    public IntegranteDto cadastrarIntegrante(IntegranteInputDto integranteInput) {
        Integrante integrante = new Integrante();
        integrante.setNome(integranteInput.getNome());
        integrante.setFuncao(integranteInput.getFuncao());
        Integrante salvo = integranteRepository.save(integrante);
        return toIntegranteDto(salvo);
    }

    @Override
    public TimeDto cadastrarTime(TimeInputDto timeInput) {
        Time time = new Time();
        time.setNomeDoClube(timeInput.getNomeDoClube());
        time.setData(timeInput.getData());
        time.setComposicaoTime(List.of());

        Time timeSalvo = timeRepository.save(time);
        List<Integrante> integrantes = findIntegrantesByIds(timeInput.getIntegranteIds());

        List<ComposicaoTime> composicaoTime = integrantes.stream()
                .map(integrante -> new ComposicaoTime(timeSalvo, integrante))
                .collect(Collectors.toList());
        composicaoTimeRepository.saveAll(composicaoTime);

        timeSalvo.setComposicaoTime(composicaoTime);
        return toTimeDto(timeSalvo);
    }

    private List<Integrante> findIntegrantesByIds(List<Long> integranteIds) {
        if (integranteIds == null || integranteIds.isEmpty()) {
            return List.of();
        }
        return integranteIds.stream()
                .map(id -> integranteRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Integrante não encontrado: " + id)))
                .collect(Collectors.toList());
    }

    private TimeDto toTimeDto(Time time) {
        return new TimeDto(
                time.getId(),
                time.getNomeDoClube(),
                time.getData(),
                time.getComposicaoTime().stream()
                        .map(c -> toIntegranteDto(c.getIntegrante()))
                        .toList());
    }

    private IntegranteDto toIntegranteDto(Integrante integrante) {
        return new IntegranteDto(
                integrante.getId(),
                integrante.getNome(),
                integrante.getFuncao());
    }
}
