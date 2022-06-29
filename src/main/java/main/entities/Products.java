package main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "brand")
    String brand;
    @Column(name = "price")
    Integer price;
    @Column(name = "color")
    String color;
    @Column(name = "size")
    Character size;

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Character getSize() {
        return size;
    }
}
