package pro.sky.recommendation_service.Mapper;

import org.springframework.jdbc.core.RowMapper;
import pro.sky.recommendation_service.DTO.Recommendation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RecommendationMapper implements RowMapper <Recommendation> {
    @Override
    public Recommendation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Recommendation()
                .setId(rs.getObject("ID", UUID.class))
                .setName(rs.getString("NAME"))
                .setSpecification(rs.getString("SPECIFICATION"));
    }
}
