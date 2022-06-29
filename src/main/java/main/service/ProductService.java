package main.service;

import main.entities.Products;
import main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public List<Products> getProductsByFilter(String brand, Integer price, String color, Character size) {
        List<Products> list= productRepository.getProductsByFilter(brand, price, color, size);
        return list;
    }
}
