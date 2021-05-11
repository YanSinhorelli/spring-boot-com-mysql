package br.com.projetob2w.springbootcommysql.controller.dto;

import java.sql.Timestamp;

public class TrilhaRq {

    private Integer id;
    private String trilhaNome;
    private String diretoria;
    private String missaoFormal;
    private String missaoAlternativa;
    private Timestamp dataAtualizacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrilhaNome() {
        return trilhaNome;
    }

    public void setTrilhaNome(String trilhaNome) {
        this.trilhaNome = trilhaNome;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }

    public String getMissaoFormal() {
        return missaoFormal;
    }

    public void setMissaoFormal(String missaoFormal) {
        this.missaoFormal = missaoFormal;
    }

    public String getMissaoAlternativa() {
        return missaoAlternativa;
    }

    public void setMissaoAlternativa(String missaoAlternativa) {
        this.missaoAlternativa = missaoAlternativa;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
