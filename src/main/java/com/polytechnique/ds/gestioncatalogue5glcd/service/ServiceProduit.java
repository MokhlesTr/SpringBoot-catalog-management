package com.polytechnique.ds.gestioncatalogue5glcd.service;

import com.polytechnique.ds.gestioncatalogue5glcd.dto.ProductMapper;
import com.polytechnique.ds.gestioncatalogue5glcd.dto.ProduitDto;
import com.polytechnique.ds.gestioncatalogue5glcd.entities.Categorie;
import com.polytechnique.ds.gestioncatalogue5glcd.entities.Produit;
import com.polytechnique.ds.gestioncatalogue5glcd.exceptions.ResourceNotFoundException;
import com.polytechnique.ds.gestioncatalogue5glcd.repository.CategorieRepository;
import com.polytechnique.ds.gestioncatalogue5glcd.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@AllArgsConstructor
@RequiredArgsConstructor
@Service
@Transactional
public class ServiceProduit implements IServiceProduit{
    //@Autowired
    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;


    /*public ServiceProduit(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }*/

    @Override
    public ProduitDto saveProduct(ProduitDto produitDto) {
         if(produitDto==null)
             return null;
         Produit p= ProductMapper.toEntity(produitDto);
         if(produitDto.getIdCategorie()!=null)
         {
             Categorie c=categorieRepository.findById(produitDto.getIdCategorie())
                     .orElseThrow(()->new ResourceNotFoundException("la categorie d'id"+produitDto.getIdCategorie()+" n'existe pas"));
             p.setCategorie(c);
         }

         Produit saved=produitRepository.save(p);

        return ProductMapper.toDto(saved);
    }

    @Override
    public ProduitDto updateProduct(Long id, ProduitDto produitDto) {
        Produit p=produitRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("le produit d'id"+id+" n'existe pas"));
        p.setNom(produitDto.getNom());
        p.setPrix(produitDto.getPrix());
        p.setQuantite(produitDto.getQuantite());
        if(produitDto.getIdCategorie()!=null)
        {
            Categorie c=categorieRepository.findById(produitDto.getIdCategorie())
                    .orElseThrow(()->new ResourceNotFoundException("la categorie d'id"+produitDto.getIdCategorie()+" n'existe pas"));
            p.setCategorie(c);
        }
        else
            p.setCategorie(null);

        Produit saved=produitRepository.save(p);

        return ProductMapper.toDto(saved);
    }

    @Override
    public void deleteProduct(Long id) {
        Produit p=produitRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("le produit d'id"+id+" n'existe pas"));

        produitRepository.delete(p);


    }

    @Override
    public ProduitDto getProductById(Long id) {
        Produit p=produitRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("le produit d'id"+id+" n'existe pas"));
        return ProductMapper.toDto(p);
    }

    @Override
    public List<ProduitDto> getAllProducts() {

       return  produitRepository.findAll().stream().map(p->ProductMapper.toDto(p)).toList();

    }

    @Override
    public List<ProduitDto> recherecherParCategorie(String nom) {

        return  produitRepository.findByCategorieNom(nom).stream().map(p->ProductMapper.toDto(p)).toList();
    }
}
