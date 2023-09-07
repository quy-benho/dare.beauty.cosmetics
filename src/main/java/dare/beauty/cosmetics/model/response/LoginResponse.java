package dare.beauty.cosmetics.model.response;

import dare.beauty.cosmetics.model.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String id;
    private String name;

    public static LoginResponse from(Account account) {
        return new LoginResponse(account.getId(), account.getUserName());
    }
}
