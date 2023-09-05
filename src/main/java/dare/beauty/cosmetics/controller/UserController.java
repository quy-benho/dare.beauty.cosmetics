package dare.beauty.cosmetics.controller;

import dare.beauty.cosmetics.model.request.LoginRequest;
import dare.beauty.cosmetics.model.response.LoginResponse;
import dare.beauty.cosmetics.model.response.ResponseData;
import dare.beauty.cosmetics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseData<LoginResponse> login(
           @RequestBody LoginRequest loginRequest
    ){
        LoginResponse result = userService.login(loginRequest);
        return ResponseData.ok(result);
    }
}
