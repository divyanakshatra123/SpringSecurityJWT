package com.Connect.postGresql.Service;

import com.Connect.postGresql.Model.Product;
import com.Connect.postGresql.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Optional<Product> findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
    productRepository.save(product);
    }
}
