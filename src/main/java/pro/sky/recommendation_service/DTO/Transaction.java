package pro.sky.recommendation_service.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class Transaction {
    private UUID id;
    private UUID productId;
    private UUID userId;
    private String type;
    private UUID amount;
}
