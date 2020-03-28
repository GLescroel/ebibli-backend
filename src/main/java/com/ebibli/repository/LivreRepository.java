package com.ebibli.repository;

import com.ebibli.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {
    List<Livre> findAllByDisponibleTrue();

    List<Livre> findAllByEmprunteurId(Integer userId);
}
