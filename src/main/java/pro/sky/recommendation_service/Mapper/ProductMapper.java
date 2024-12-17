package pro.sky.recommendation_service.Mapper;

import org.springframework.jdbc.core.RowMapper;
import pro.sky.recommendation_service.DTO.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product()
                .setId(rs.getObject("ID", UUID.class))
                .setName(rs.getString("NAME"))
                .setType(rs.getString("TYPE"));
    }
}
