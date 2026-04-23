package br.com.duxusdesafio.Application.Dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TimeInputDto {

    private String nomeDoClube;
    private LocalDate data;
    private List<Long> integranteIds;

    public TimeInputDto() {
    }

    public TimeInputDto(String nomeDoClube, LocalDate data, List<Long> integranteIds) {
        this.nomeDoClube = nomeDoClube;
        this.data = data;
        this.integranteIds = integranteIds;
    }

    public String getNomeDoClube() {
        return nomeDoClube;
    }

    public void setNomeDoClube(String nomeDoClube) {
        this.nomeDoClube = nomeDoClube;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Long> getIntegranteIds() {
        return integranteIds;
    }

    public void setIntegranteIds(List<Long> integranteIds) {
        this.integranteIds = integranteIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TimeInputDto))
            return false;
        TimeInputDto that = (TimeInputDto) o;
        return Objects.equals(nomeDoClube, that.nomeDoClube) && Objects.equals(data, that.data)
                && Objects.equals(integranteIds, that.integranteIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoClube, data, integranteIds);
    }
}
