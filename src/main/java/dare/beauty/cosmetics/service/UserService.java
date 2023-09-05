package dare.beauty.cosmetics.service;

import dare.beauty.cosmetics.model.request.LoginRequest;
import dare.beauty.cosmetics.model.response.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
}
