package main.repository;

import main.entities.Products;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductCustomRepositoryImpl implements ProductCustomRepository {
    @PersistenceContext
    EntityManager entityManager;


    //how about having variable argument method here. ?? but here we need to know what parameter it is, while constrcuting query.
    @Override
    public List<Products> getProductsByFilter(String brand, Integer price, String color, Character size) {
        StringBuffer query = new StringBuffer();
        if (brand == null && price == null && color == null && size == null) {
            query.append("select p from Products p");   //be cautious of HQL/JPQL syntax
        } else {
            int i = 1;
            query.append("select p from Products p where ");
            if (brand != null) {

                if (i > 1) {
                    query.append(" AND p.brand=:brand");
                } else {
                    query.append("p.brand=:brand");
                }
                i++;

            }
            if (price != null) {
                if (i > 1) {
                    query.append(" AND p.price=:price");
                } else {
                    query.append("p.price=:price");
                }

                i++;
            }
            if (color != null) {
                if (i > 1) {
                    query.append(" AND p.color=:color");
                } else {
                    query.append("p.color=:color");
                }
                i++;
            }
            if (size != null) {
                if (i > 1) {
                    query.append(" AND p.size=:size");
                } else {
                    query.append("p.size=:size");
                }
                i++;
            }
        }

        System.out.println(query.toString());
        TypedQuery<Products> namedQuery = entityManager.createQuery(query.toString(), Products.class);
        try {
            //set named parameter to variable value
            namedQuery.setParameter("brand", brand);
        } catch (Exception e) {

        }
        try {
            //set named parameter to variable value
            namedQuery.setParameter("price", price);
        } catch (Exception e) {

        }
        try {
            //set named parameter to variable value
            namedQuery.setParameter("color", color);
        } catch (Exception e) {

        }
        try {
            //set named parameter to variable value
            namedQuery.setParameter("size", size);
        } catch (Exception e) {

        }
        return namedQuery.getResultList();
    }
}
