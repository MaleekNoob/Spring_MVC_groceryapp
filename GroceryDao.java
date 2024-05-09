package com.example.grocerymanagement.dao;

import com.example.grocerymanagement.bean.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GroceryDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Grocery grocery){
        String sql="INSERT INTO grocery (name, price, quantity) VALUES (" + grocery.getName() + ", " + grocery.getPrice() + ", " + grocery.getQuantity() + ")";
        return template.update(sql);
    }

    public int update(Grocery grocery){
        String sql="UPDATE grocery SET name=" + grocery.getName() + ", price=" + grocery.getPrice() + ", quantity=" + grocery.getQuantity() + " WHERE id=" + grocery.getId();
        return template.update(sql);
    }

    public int delete(int id){
        String sql="DELETE FROM grocery WHERE id=" + id;
        return template.update(sql);
    }

    public Grocery getGroceryById(int id){
        String sql="SELECT * FROM grocery WHERE id=" + id;
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Grocery.class));
    }

    public List<Grocery> getGroceries(){
        return template.query("SELECT * FROM grocery",new RowMapper<Grocery>(){
            public Grocery mapRow(ResultSet rs, int row) throws SQLException {
                Grocery grocery = new Grocery();
                grocery.setId(rs.getInt("id"));
                grocery.setName(rs.getString("name"));
                grocery.setPrice(rs.getDouble("price"));
                grocery.setQuantity(rs.getInt("quantity"));
                return grocery;
            }
        });
    }
}
