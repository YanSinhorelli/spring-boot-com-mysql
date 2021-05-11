package br.com.projetob2w.springbootcommysql.repository;

import org.springframework.stereotype.Repository;

import br.com.projetob2w.springbootcommysql.model.Cargo;
import br.com.projetob2w.springbootcommysql.model.Trilha;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CargoCustomRepository {

    private final EntityManager em;

    public CargoCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Cargo> find(Integer id, String cargo_nome, Trilha trilha_id) {

        String query = "select P from Cargo as P ";
        String condicao = "where";

        if(id != null) {
            query += condicao + " P.id = :id";
            condicao = " and ";
        }

        if(cargo_nome != null) {
            query += condicao + " P.cargo_nome = :cargo_nome";
            condicao = " and ";
        }

        if(trilha_id != null) {
            query += condicao + " P.trilha_id = :trilha_id";
        }

        var q = em.createQuery(query, Cargo.class);

        if(id != null) {
            q.setParameter("id", id);
        }

        if(cargo_nome != null) {
            q.setParameter("cargo_nome", cargo_nome);
        }

        if(trilha_id != null) {
            q.setParameter("trilha_id", trilha_id);
        }

        return q.getResultList();
    }

}
