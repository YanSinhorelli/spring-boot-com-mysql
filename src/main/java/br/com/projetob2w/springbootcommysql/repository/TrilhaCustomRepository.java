package br.com.projetob2w.springbootcommysql.repository;

import org.springframework.stereotype.Repository;

import br.com.projetob2w.springbootcommysql.model.Trilha;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TrilhaCustomRepository {

    private final EntityManager em;

    public TrilhaCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Trilha> find(Integer id, String trilha_nome, String diretoria) {

        String query = "select P from Trilha as P ";
        String condicao = "where";

        if(id != null) {
            query += condicao + " P.id = :id";
            condicao = " and ";
        }

        if(trilha_nome != null) {
            query += condicao + " P.trilha_nome = :trilha_nome";
            condicao = " and ";
        }

        if(diretoria != null) {
            query += condicao + " P.diretoria = :diretoria";
        }

        var q = em.createQuery(query, Trilha.class);

        if(id != null) {
            q.setParameter("id", id);
        }

        if(trilha_nome != null) {
            q.setParameter("trilha_nome", trilha_nome);
        }

        if(diretoria != null) {
            q.setParameter("diretoria", diretoria);
        }

        return q.getResultList();
    }

}
