package pro.sky.recommendation_service.Mapper;

import org.springframework.jdbc.core.RowMapper;
import pro.sky.recommendation_service.DTO.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper<pro.sky.recommendation_service.DTO.User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User()
                .setId(rs.getObject("ID", UUID.class))
                .setUserName(rs.getString("USERNAME"))
                .setFirstName(rs.getString("FIRST_NAME"))
                .setLastName(rs.getString("LAST_NAME"));
    }
}
