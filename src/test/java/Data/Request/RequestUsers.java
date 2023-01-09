package Data.Request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RequestUsers {
    String id;
    String first_name;
    String last_name;
    String email;
    String avatar;
}
