package br.com.zup.libraryZup.controllers;

import br.com.zup.authenticator.controllers.dtos.RegisterUserDto;
import br.com.zup.authenticator.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class LoginController {

    private final UserService userService;

    @PostMapping
    public void registerUser(@RequestBody RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);
    }
}
