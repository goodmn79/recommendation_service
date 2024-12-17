package pro.sky.recommendation_service.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class Recommendation {
    private UUID id;
    private String name;
    private String specification;
}
