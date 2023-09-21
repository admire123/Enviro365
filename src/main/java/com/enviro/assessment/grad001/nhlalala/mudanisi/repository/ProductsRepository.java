package com.enviro.assessment.grad001.nhlalala.mudanisi.repository;

import com.enviro.assessment.grad001.nhlalala.mudanisi.entity.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {
}
