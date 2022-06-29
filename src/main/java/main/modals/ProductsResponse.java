package main.modals;


public class ProductsResponse {

    private Integer id;
    private String brand;
    private Integer price;
    private String color;
    private Character size;


    public ProductsResponse() {
    }

    public ProductsResponse(Integer id, String brand, Integer price, String color, Character size) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.size = size;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(Character size) {
        this.size = size;
    }

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
