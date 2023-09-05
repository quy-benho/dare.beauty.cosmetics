package dare.beauty.cosmetics.model.response;

import dare.beauty.cosmetics.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String id;
    private String name;

    public static LoginResponse from(User user) {
        return new LoginResponse(user.getId(), user.getName());
    }
}
