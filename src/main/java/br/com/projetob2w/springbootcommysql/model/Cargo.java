package br.com.projetob2w.springbootcommysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name ="cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cargo_nome")
    private String cargoNome;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "trilha_id")
    private Trilha trilha;

    @Column(name="cargo_missao")
    private String cargoMissao;

    @Column(name="data_atualizacao")
    private Timestamp dataAtualizacao;

    public Cargo() {
    }

    public Cargo(Integer id, String cargoNome, Trilha trilha, String cargoMissao, Timestamp dataAtualizacao) {
        this.id = id;
        this.cargoNome = cargoNome;
        this.trilha = trilha;
        this.cargoMissao = cargoMissao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Cargo(String cargoNome, Trilha trilha, String cargoMissao, Timestamp dataAtualizacao) {
        this.cargoNome = cargoNome;
        this.trilha = trilha;
        this.cargoMissao = cargoMissao;
        this.dataAtualizacao = dataAtualizacao;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(id, cargo.id) &&
                Objects.equals(cargoNome, cargo.cargoNome) &&
                Objects.equals(trilha, cargo.trilha) &&
                Objects.equals(cargoMissao, cargo.cargoMissao) &&
                Objects.equals(dataAtualizacao, cargo.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cargoNome, trilha, cargoMissao, dataAtualizacao);
    }
}
