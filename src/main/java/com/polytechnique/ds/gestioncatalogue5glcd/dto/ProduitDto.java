package com.polytechnique.ds.gestioncatalogue5glcd.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDto {

    private Long id;
    @NotBlank(message = "Le nom du produit est obligatoire")
    private String nom;
    @Min(value = 0,message = "Le prix doit être supérieur ou égal à 0")
    private double prix;
    @Min(value = 1,message = "La quantité doit être supérieur ou égal à 1")
    private int quantite;
    private Long idCategorie;
    private String nomCategorie;
}
