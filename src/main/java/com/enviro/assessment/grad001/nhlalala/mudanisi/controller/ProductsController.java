package com.enviro.assessment.grad001.nhlalala.mudanisi.controller;

import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.InvestorInformation;
import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.Products;
import com.enviro.assessment.grad001.nhlalala.mudanisi.service.InvestorInformationService;
import com.enviro.assessment.grad001.nhlalala.mudanisi.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // @RestController is a combination of @Controller and @ResponseBody.
@RequestMapping("products/api")
public class ProductsController {

    /*
    @Autowired your ProductsService for dependency injection

    This class is where you can implement the actual business logic of processing information
    Methods are called from the autowired service above that calls our crud methods from ProductsRepository
     */
    @Autowired
    private ProductsService productsService;

    @GetMapping("/findall")
    public List<Products> findAllProducts(){
        return productsService.findAllProducts();
    }

    @GetMapping("/findbyid/{id}")
    @ResponseBody
    public ResponseEntity<Products> findProductById(@PathVariable(value = "id") Long id) {
        Optional<Products> products= productsService.findById(id);

        /*
        If the products.isPresent(), a 200 OK HTTP response is returned, else,
         a ResponseEntity.notFound() is returned.
         */
        if(products.isPresent()) {
            return ResponseEntity.ok().body(products.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    The @Validated annotation is used to enforce basic validity for the data provided about the product.
     The @RequestBody annotation is used to map the body of the POST request sent to the endpoint to the Products instance you’d like to save.
     */
    @PostMapping("/save")
    public Products saveProduct(@Validated @RequestBody Products products) {
        return productsService.saveProduct(products);
    }

}
