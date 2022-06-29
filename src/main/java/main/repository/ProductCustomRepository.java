package main.repository;

import main.entities.Products;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCustomRepository {

    List<Products> getProductsByFilter(String brand, Integer price, String color, Character size);
}
