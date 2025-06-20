package com.Pluralsight.NorthwindTradersSpringBoot.Dao;

import com.Pluralsight.NorthwindTradersSpringBoot.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements IProductDao {
    final private List<Product> products = new ArrayList<>();
    @Autowired
    private DataSource dataSource;

    @Override
    public void add(Product product) {
        String query = "Insert into Products (ProductName,CategoryID,UnitPrice) VALUES ( ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getCategory());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Product> getAll() {
        String query = "Select * from products";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Product product = new Product();
                product.setProductId(set.getInt("ProductId"));
                product.setName(set.getString("ProductName"));
                product.setCategory(set.getInt("CategoryID"));
                product.setPrice(set.getDouble("UnitPrice"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

