package br.com.projetob2w.springbootcommysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projetob2w.springbootcommysql.model.Trilha;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Integer> {
    List<Trilha> findByTrilhaNomeContains(String name);
}
