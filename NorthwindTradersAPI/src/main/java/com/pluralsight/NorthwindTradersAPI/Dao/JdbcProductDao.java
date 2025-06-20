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

    @Override
    public Product addProduct(Product product) {
        String query="Insert into products (ProductId,productName,categoryId,unitPrice) values (?, ?, ?, ?)";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setInt(3,product.getCategoryId());
            statement.setDouble(4,product.getPrice());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(int id, Product product) {
        String query ="Update Products SET ProductName=? where ProductId=?";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, product.getProductName());
            statement.setInt(2,product.getProductId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void Delete(int id) {
        String query="DELETE FROM products where productId=?";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
