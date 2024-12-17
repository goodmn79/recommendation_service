package pro.sky.recommendation_service.Mapper;

import org.springframework.jdbc.core.RowMapper;
import pro.sky.recommendation_service.DTO.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TransactionMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Transaction()
                .setId(rs.getObject("ID", UUID.class))
                .setProductId(rs.getObject("PRODUCTID",UUID.class))
                .setUserId(rs.getObject("USERID", UUID.class))
                .setType(rs.getString("TYPE"))
                .setAmount(rs.getObject("AMOUNT", UUID.class));
    }
}
