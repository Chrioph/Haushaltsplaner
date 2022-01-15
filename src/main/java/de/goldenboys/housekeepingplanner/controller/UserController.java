package de.goldenboys.housekeepingplanner.controller;

import de.goldenboys.housekeepingplanner.model.User;
import de.goldenboys.housekeepingplanner.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository ur) {
        this.userRepository = ur;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.id = null;
        user = userRepository.save(user);
        return ResponseEntity.created(URI.create("/users/" + user.id)).body(user);
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(maybeUser.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (user.id != null && user.id != id) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        HttpStatus status = user.id == null ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(userRepository.save(user));
    }
}
