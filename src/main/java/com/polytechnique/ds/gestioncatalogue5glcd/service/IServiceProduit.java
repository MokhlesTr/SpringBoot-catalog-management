package com.polytechnique.ds.gestioncatalogue5glcd.service;

import com.polytechnique.ds.gestioncatalogue5glcd.dto.ProduitDto;

import java.util.List;

public interface IServiceProduit {

    ProduitDto saveProduct(ProduitDto produitDto);
    ProduitDto updateProduct(Long id, ProduitDto produitDto);
    void deleteProduct(Long id);
    ProduitDto getProductById(Long id);
    List<ProduitDto> getAllProducts();
    List<ProduitDto> recherecherParCategorie(String nom);

}
