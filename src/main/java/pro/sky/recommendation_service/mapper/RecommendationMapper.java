package pro.sky.recommendation_service.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pro.sky.recommendation_service.dto.Recommendation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
@Component
public class RecommendationMapper implements RowMapper <Recommendation> {
    @Override
    public Recommendation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Recommendation()
                .setId(rs.getObject("ID", UUID.class))
                .setName(rs.getString("NAME"))
                .setSpecification(rs.getString("SPECIFICATION"));
    }
}
