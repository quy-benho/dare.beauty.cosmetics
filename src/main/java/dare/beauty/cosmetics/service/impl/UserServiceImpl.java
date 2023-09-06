package dare.beauty.cosmetics.service.impl;

import dare.beauty.cosmetics.data.repository.AccountRepository;
import dare.beauty.cosmetics.model.entities.User;
import dare.beauty.cosmetics.model.request.LoginRequest;
import dare.beauty.cosmetics.model.response.LoginResponse;
import dare.beauty.cosmetics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = accountRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        return LoginResponse.from(user);
    }
}
