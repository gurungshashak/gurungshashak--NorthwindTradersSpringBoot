package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.Product;
import com.pluralsight.NorthwindTradersSpringBoot.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Component
public class JdbcProductDao implements ProductDao {
    private DataSource dataSource;
    private List<Product> products;
    final Scanner scanner = new Scanner(System.in);


    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.products = new ArrayList<>();
    }



    @Override
    public void add(Product product) {
                String query = """
        INSERT INTO products (productName, categoryID, UnitPrice)
        VALUES (?, (SELECT categoryID FROM categories WHERE categoryName = ?), ?)
    """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getCategory());
            statement.setDouble(4, product.getPrice());

            statement.executeUpdate();
            System.out.println("Product added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




            @Override
    public List<Product> getAll() {
        products.clear();
        String query = "select p.productID, p.productName,c.categoryName, p.UnitPrice from products as p join categories as c  on (c.categoryID = p.categoryID)";

        try {
            Connection connection = dataSource.getConnection();
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet set = statement.executeQuery();
                while(set.next()) {
                    products.add(new Product(set.getInt(1), set.getString(2),set.getString(3),set.getDouble(4)));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public void delete() {
    }
}

