package com.polytechnique.ds.gestioncatalogue5glcd.repository;

import com.polytechnique.ds.gestioncatalogue5glcd.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    //derived query
    List<Produit> findByCategorieNom(String nom);

    //JPQL
    @Query("select p from Produit p where p.categorie.nom=:x")
    List<Produit> recherecherParNomCategorie(@Param("x") String nom);



}
