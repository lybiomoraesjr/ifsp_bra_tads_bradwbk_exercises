package br.edu.ifsp.user_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.user_api.dto.CreateUserDTO;
import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
    // Definição da API REST

    @Autowired
    UserService userService;

    @GetMapping("user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUserList();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getOneUser(
            @PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null)
            return ResponseEntity.ok().body(user); // Status 200
        return ResponseEntity.notFound().build(); // Status 404
    }

    @PostMapping("user")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO dto) {
        User user = userService.createUser(dto);

        return ResponseEntity
                .created(URI.create("/api/user/" + user.getId()))
                .build();
    }
}
