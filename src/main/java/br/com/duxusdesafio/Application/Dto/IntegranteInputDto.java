package br.com.duxusdesafio.Application.Dto;

import java.util.Objects;

public class IntegranteInputDto {

    private String nome;
    private String funcao;

    public IntegranteInputDto() {
    }

    public IntegranteInputDto(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof IntegranteInputDto))
            return false;
        IntegranteInputDto that = (IntegranteInputDto) o;
        return Objects.equals(nome, that.nome) && Objects.equals(funcao, that.funcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, funcao);
    }
}
