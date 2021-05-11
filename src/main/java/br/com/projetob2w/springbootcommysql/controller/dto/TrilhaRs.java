package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TrilhaRs {

    private Integer id;
    private String trilhaNome;
    private String diretoria;
    private String missaoFormal;
    private String missaoAlternativa;
    private Timestamp dataAtualizacao;

    public static TrilhaRs converter(Trilha t) {
        var trilha = new TrilhaRs();
        trilha.setId(t.getId());
        trilha.setTrilhaNome(t.getTrilhaNome());
        trilha.setDiretoria(t.getDiretoria());
        trilha.setMissaoFormal(t.getMissaoFormal());
        trilha.setMissaoAlternativa(t.getMissaoAlternativa());
        trilha.setDataAtualizacao(t.getDataAtualizacao());
        return trilha;
    }

    public static Trilha converterToTrilha(TrilhaRs trilhaRs){
        var trilha = new Trilha();
        trilha.setId(trilhaRs.getId());
        trilha.setTrilhaNome(trilhaRs.getTrilhaNome());
        trilha.setDiretoria(trilhaRs.getDiretoria());
        trilha.setMissaoFormal(trilhaRs.getMissaoFormal());
        trilha.setMissaoAlternativa(trilhaRs.getMissaoAlternativa());
        trilha.setDataAtualizacao(trilhaRs.getDataAtualizacao());
        return trilha;
    }

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
