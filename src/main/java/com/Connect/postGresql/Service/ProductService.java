package com.Connect.postGresql.Service;

import com.Connect.postGresql.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(int id);
    List<Product> getAll();
    void save(Product product);
}
