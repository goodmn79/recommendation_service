package pro.sky.recommendation_service.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)

public class User {
    private UUID id;
    private String userName;
    private String lastName;
    private String firstName;

}