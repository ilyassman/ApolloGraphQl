package com.ensa.projet.banqueservice.repository;

import com.ensa.projet.banqueservice.entities.Compte;
import com.ensa.projet.banqueservice.entities.TypeCompte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompteRepository  extends JpaRepository<Compte, Long> {
    @Query("SELECT COALESCE(SUM(c.solde), 0) FROM Compte c")
    double sumSoldes();
    List <Compte> findByType(TypeCompte type);
}
