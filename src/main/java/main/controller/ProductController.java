package main.controller;


import main.entities.Products;
import main.modals.ProductsResponse;
import main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductsResponse>> getProductsByFilter(@RequestParam(name = "brand", required = false) String brand,
                                                                      @RequestParam(name = "price", required = false) Integer price,
                                                                      @RequestParam(name = "color", required = false) String color,
                                                                      @RequestParam(name = "size", required = false) Character size) {


        //note that http request must comply to httpspec. here requestparams have been made optional


        List<Products> list = productService.getProductsByFilter(brand, price, color, size);
        List<ProductsResponse> responseList = new LinkedList<>();
        for (Products prod : list) {
            ProductsResponse productsResponse = new ProductsResponse();
            productsResponse.setBrand(prod.getBrand());
            productsResponse.setColor(prod.getColor());
            productsResponse.setSize(prod.getSize());
            productsResponse.setId(prod.getId());
            productsResponse.setPrice(prod.getPrice());
            responseList.add(productsResponse);
        }
        return new ResponseEntity<List<ProductsResponse>>(responseList, HttpStatus.OK);

    }
}
