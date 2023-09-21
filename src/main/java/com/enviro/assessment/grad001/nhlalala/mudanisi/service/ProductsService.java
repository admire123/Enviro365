package com.enviro.assessment.grad001.nhlalala.mudanisi.service;

import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.InvestorInformation;
import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.Products;
import com.enviro.assessment.grad001.nhlalala.mudanisi.repository.InvestorInformationRepository;
import com.enviro.assessment.grad001.nhlalala.mudanisi.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public List<Products> findAllProducts(){
        return (List<Products>) productsRepository.findAll();
    }

    public Optional<Products> findById(Long id){
        return productsRepository.findById(id);
    }

    public Products saveProduct(Products products){
        return productsRepository.save(products);
    }


}