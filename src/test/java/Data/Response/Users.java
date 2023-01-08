package Data.Response;

import io.restassured.response.Response;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Users {
    String id;
    String first_name;
    String last_name;
    String email;
    String avatar;

}
