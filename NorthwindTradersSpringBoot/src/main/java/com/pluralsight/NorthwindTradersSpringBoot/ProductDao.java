package com.pluralsight.NorthwindTradersSpringBoot;

import java.util.List;
import java.util.Scanner;

public interface ProductDao {
    public void add(Product product);
    public List<Product> getAll();
    public void delete();
}
