package com.polytechnique.ds.gestioncatalogue5glcd;

import com.polytechnique.ds.gestioncatalogue5glcd.entities.Categorie;
import com.polytechnique.ds.gestioncatalogue5glcd.entities.Produit;
import com.polytechnique.ds.gestioncatalogue5glcd.repository.CategorieRepository;
import com.polytechnique.ds.gestioncatalogue5glcd.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Gestioncatalogue5GlcdApplication {

    @Bean
    CommandLineRunner commandLineRunner(ProduitRepository produitRepository, CategorieRepository categorieRepository)
    {
        return args->{
            Categorie c1 = new Categorie(null,"informatique",null);
            Categorie c2= Categorie.builder()
                    .nom("electonique")
                    .build();
            categorieRepository.save(c1);
            categorieRepository.save(c2);
            produitRepository.save(Produit.builder()
                            .nom("pc")
                            .quantite(10)
                            .prix(5000)
                            .categorie(c1)
                    .build());
            produitRepository.save(Produit.builder()
                    .nom("clavier")
                    .quantite(10)
                    .prix(50)
                    .categorie(c1)
                    .build());
            produitRepository.save(Produit.builder()
                    .nom("smartphone")
                    .quantite(10)
                    .prix(5000)
                    .categorie(c2)
                    .build());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Gestioncatalogue5GlcdApplication.class, args);
    }

}
