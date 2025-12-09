package com.pluralsight.NorthwindTradersSpringBoot;
/*
productId - int
name - String
category - String (for now)
price - double (or BigDecimal)
 */

public class Product {
    private String name;
    private int productId;
    private String category;
    private double price;

    public Product(int productId, String name, String category, double price) {
        this.name = name;
        this.productId = productId;
        this.category = category;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String toString() {
        return "\n" + "productId: " + productId + "\n" +
                "Product name: " + name + "\n" +
                "Category: " + category + "\n" + "Price: " + price + "\n";
    }
}
