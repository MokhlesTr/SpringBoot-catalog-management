package com.polytechnique.ds.gestioncatalogue5glcd.repository;

import com.polytechnique.ds.gestioncatalogue5glcd.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
