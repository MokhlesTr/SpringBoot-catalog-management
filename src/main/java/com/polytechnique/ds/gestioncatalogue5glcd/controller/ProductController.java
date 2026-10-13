package com.polytechnique.ds.gestioncatalogue5glcd.controller;

import com.polytechnique.ds.gestioncatalogue5glcd.service.IServiceProduit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
//@CrossOrigin("*")
public class ProductController {
    private final IServiceProduit serviceProduit;
    
}
