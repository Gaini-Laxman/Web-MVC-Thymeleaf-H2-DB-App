package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klinnovations.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
