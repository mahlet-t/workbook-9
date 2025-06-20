package com.pluralsight.NorthwindTradersAPI.Dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCategoryDao implements CategoryDao {
   final private List<Category> categories=new ArrayList<>();
   final private DataSource dataSource;

    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        String query="Select * from categories";
        try (Connection connection= dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
              int id=  resultSet.getInt("CategoryID");
              String name=  resultSet.getString("CategoryName");
                categories.add(new Category(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return categories;
    }

    @Override
    public Category categoryGetById(int id) {
        String query="Select * from categories where categoryId=?";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()){
              int categoryId=  resultSet.getInt("CategoryID");
               String categoryName= resultSet.getString("CategoryName");
                return new Category(categoryId,categoryName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Category add(Category category) {
        String query ="Insert into Categories (categoryId,categoryName) values(?, ?)";
        try (Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,category.getCategoryId());
            statement.setString(2,category.getCategoryName());
            statement.executeUpdate();
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(int id, Category category) {
        String query="update categories SET categoryName=? where categoryID=?";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,category.getCategoryName());
            statement.setInt(2,category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String query="DELETE From categories where categoryID=?";
        try(Connection connection= dataSource.getConnection()){
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
