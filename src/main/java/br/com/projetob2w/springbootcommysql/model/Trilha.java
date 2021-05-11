package br.com.projetob2w.springbootcommysql.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "trilha")
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="trilha_nome")
    private String trilhaNome;

    @Column(name="diretoria")
    private String diretoria;

    @Column(name="missao_formal")
    private String missaoFormal;

    @Column(name="missao_alternativa")
    private String missaoAlternativa;

    @Column(name="data_atualizacao")
    private Timestamp dataAtualizacao;

    public Trilha() {
    }

    public Trilha(Integer id, String trilhaNome, String diretoria, String missaoFormal, String missaoAlternativa, Timestamp dataAtualizacao) {
        this.id = id;
        this.trilhaNome = trilhaNome;
        this.diretoria = diretoria;
        this.missaoFormal = missaoFormal;
        this.missaoAlternativa = missaoAlternativa;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Trilha(String trilhaNome, String diretoria, String missaoFormal, String missaoAlternativa, Timestamp dataAtualizacao) {
        this.trilhaNome = trilhaNome;
        this.diretoria = diretoria;
        this.missaoFormal = missaoFormal;
        this.missaoAlternativa = missaoAlternativa;
        this.dataAtualizacao = dataAtualizacao;
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

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trilha trilha = (Trilha) o;
        return Objects.equals(id, trilha.id) &&
                Objects.equals(trilhaNome, trilha.trilhaNome) &&
                Objects.equals(diretoria, trilha.diretoria) &&
                Objects.equals(missaoFormal, trilha.missaoFormal) &&
                Objects.equals(missaoAlternativa, trilha.missaoAlternativa) &&
                Objects.equals(dataAtualizacao, trilha.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trilhaNome, diretoria, missaoFormal, missaoAlternativa, dataAtualizacao);
    }
}
