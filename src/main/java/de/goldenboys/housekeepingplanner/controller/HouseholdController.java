package de.goldenboys.housekeepingplanner.controller;

import de.goldenboys.housekeepingplanner.model.Household;
import de.goldenboys.housekeepingplanner.model.User;
import de.goldenboys.housekeepingplanner.repository.HouseholdRepository;
import de.goldenboys.housekeepingplanner.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {
    private final HouseholdRepository householdRepository;
    private final UserRepository userRepository;

    public HouseholdController(HouseholdRepository hr, UserRepository ur) {
        this.householdRepository = hr;
        this.userRepository = ur;
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody Household household) {
        household.id = null;
        household = householdRepository.save(household);
        return ResponseEntity.created(URI.create("/households/" + household.id)).build();
    }

    @GetMapping
    public Iterable<Household> getHouseholds() {
        return householdRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Household> getHouseholdById(@PathVariable Long id) {
        Optional<Household> maybeHousehold = householdRepository.findById(id);
        if (maybeHousehold.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(maybeHousehold.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHouseholdById(@PathVariable Long id) {
        householdRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Household> updateHousehold(@PathVariable Long id, @RequestBody Household household) {
        if (household.id != null && household.id != id) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        HttpStatus status = household.id == null ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(householdRepository.save(household));
    }

    @PutMapping("{id}/addUser/{user}")
    public ResponseEntity<Household> addUser(@PathVariable Long householdId, @PathVariable Long userId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        Optional<Household> maybeHousehold = householdRepository.findById(householdId);
        if (maybeUser.isEmpty() || maybeHousehold.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Household household = maybeHousehold.get();
        User user = maybeUser.get();
        household.users.add(user);
        userRepository.save(user);
        return ResponseEntity.ok(householdRepository.save(household));
    }
}
