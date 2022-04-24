package com.fundamentosplatzispringboot.fundamentos.usecase;

import com.fundamentosplatzispringboot.fundamentos.entity.User;
import com.fundamentosplatzispringboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.update(newUser,id);
    }
}
