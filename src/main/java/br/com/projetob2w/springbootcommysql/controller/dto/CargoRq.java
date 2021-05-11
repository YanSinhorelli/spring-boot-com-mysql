package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;

public class CargoRq {

    private String cargoNome;
    private Trilha trilha;
    private String cargoMissao;
    private Timestamp dataAtualizacao;

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = cargoNome;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    public String getCargoMissao() {
        return cargoMissao;
    }

    public void setCargoMissao(String cargoMissao) {
        this.cargoMissao = cargoMissao;
    }

    public Timestamp getDataAtualizacaoNow() {
        return dataAtualizacao = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
