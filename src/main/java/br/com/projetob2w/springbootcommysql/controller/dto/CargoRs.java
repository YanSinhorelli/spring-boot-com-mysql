package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Cargo;
import br.com.projetob2w.springbootcommysql.model.Trilha;

import java.sql.Timestamp;

public class CargoRs {

    private Integer id;
    private String cargoNome;
    private Trilha trilha;
    private String cargoMissao;
    private Timestamp dataAtualizacao;

    public static CargoRs converter(Cargo c) {
        var cargo = new CargoRs();
        cargo.setId(c.getId());
        cargo.setCargoNome(c.getCargoNome());
        cargo.setTrilha(c.getTrilha());
        cargo.setCargoMissao(c.getCargoMissao());
        cargo.setDataAtualizacao(c.getDataAtualizacao());
        return cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
