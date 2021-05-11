package br.com.projetob2w.springbootcommysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projetob2w.springbootcommysql.model.Cargo;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    List<Cargo> findByCargoNomeContains(String name);
}
