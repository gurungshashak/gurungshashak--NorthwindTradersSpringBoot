package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class SimpleProductDao implements ProductDao {
    private List<Product> products;
    static Scanner scanner = new Scanner(System.in);


    public SimpleProductDao() {
        this.products = new ArrayList<>();
        this.products.add(new Product(101,"Wireless Mouse","Electronics",29.99));
        this.products.add(new Product(102,"Stainless Steel Water Bottle","Home & Kitchen",18.50));
        this.products.add(new Product(103,"Bluetooth Headphones","Electronics",59.95));

    }


    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public void delete() {
        System.out.print("\nEnter product ID to delete: ");
        int value = scanner.nextInt();

        boolean found = false;

        Iterator<Product> it = this.products.iterator();

        while (it.hasNext()) {
            Product product = it.next();

            if (product.getProductId() == value) {
                it.remove();
                System.out.println("\n\t" + product.getName() + " Has Been Deleted!!\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nProduct not found!\n");
        }
    }
}
