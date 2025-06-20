package com.pluralsight.NorthwindTradersAPI.Dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcProductDao implements ProductDao{
   final private List<Product> products=new ArrayList<>();

   final private DataSource dataSource;
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Product> getAll() {
      String query ="Select * from products";
      try(Connection connection=dataSource.getConnection()){
          PreparedStatement statement= connection.prepareStatement(query);
          ResultSet resultSet= statement.executeQuery();
          while (resultSet.next()){
            int id=  resultSet.getInt("ProductId");
             String name= resultSet.getString("ProductName");
             int categoryId= resultSet.getInt("CategoryID");
             double price= resultSet.getDouble("UnitPrice");
             products.add(new Product(id,name,categoryId,price));
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
        return products;
    }

    @Override
    public Product productGetById(int id) {
        String query="Select * from products where productId=?";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();

                if (resultSet.next()){
                    int productId= resultSet.getInt("ProductId");
                    String productName=resultSet.getString("ProductName");
                    int categoryId=resultSet.getInt("categoryID");
                    double price=resultSet.getDouble("UnitPrice");
                    return new Product(productId,productName,categoryId,price);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
