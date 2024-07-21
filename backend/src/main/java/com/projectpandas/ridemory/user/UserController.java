package com.projectpandas.ridemory.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpandas.ridemory.util.dto.EmailDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Sign up for a new account.
     *
     * @param email the email of the new user
     * @return new user
     */
    @PostMapping
    public ResponseEntity<User> signUp(@RequestBody EmailDto email) {
        User user = userService.createUser(email);
        return user == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(user);
    }
}
