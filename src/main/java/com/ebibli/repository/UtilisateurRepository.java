package com.ebibli.repository;

import com.ebibli.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findUtilisateurByEmail(String email);
}
