package pro.sky.recommendation_service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pro.sky.recommendation_service.dto.Product;
import pro.sky.recommendation_service.dto.Transaction;
import pro.sky.recommendation_service.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
@Component
public class TransactionMapper implements RowMapper <Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User()
                .setId(rs.getObject("ID", UUID.class))
                .setUserName(rs.getString("USERNAME"))
                .setFirstName(rs.getString("FIRST_NAME"))
                .setLastName(rs.getString("LAST_NAME"));

        Product product = new Product()
                .setId(rs.getObject("ID", UUID.class))
                .setName(rs.getString("NAME"))
                .setType(rs.getString("TYPE"));

        return new Transaction()
                .setId(rs.getObject("ID", UUID.class))
                .setProduct(product)
                .setUser(user)
                .setType(rs.getString("TYPE"))
                .setAmount(rs.getObject("AMOUNT", Integer.class));
    }
}
