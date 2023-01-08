package Data.Response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Posts {
    String id;
    String title;
    String author;
}
