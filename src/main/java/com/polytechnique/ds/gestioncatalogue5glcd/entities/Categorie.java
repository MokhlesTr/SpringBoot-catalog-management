package com.polytechnique.ds.gestioncatalogue5glcd.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Categorie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "categorie",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Produit> produits;
}
