package com.polytechnique.ds.gestioncatalogue5glcd.dto;

import com.polytechnique.ds.gestioncatalogue5glcd.entities.Categorie;
import com.polytechnique.ds.gestioncatalogue5glcd.entities.Produit;

public class ProductMapper {

    public static ProduitDto toDto(Produit p)
    {
        if(p==null) return null;
        ProduitDto dto= ProduitDto.builder()
                .id(p.getId())
                .nom(p.getNom())
                .prix(p.getPrix())
                .quantite(p.getQuantite())
                .build();
                if(p.getCategorie()!=null)
                {
                    dto.setIdCategorie(p.getCategorie().getId());
                    dto.setNomCategorie(p.getCategorie().getNom());
                }
        return dto;
    }
    public static Produit toEntity(ProduitDto dto)
    {
        if(dto==null) return null;
        return Produit.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .prix(dto.getPrix())
                .quantite(dto.getQuantite())
               // .categorie(Categorie.builder().id(dto.getIdCategorie()).build())
                .build();


    }
}
