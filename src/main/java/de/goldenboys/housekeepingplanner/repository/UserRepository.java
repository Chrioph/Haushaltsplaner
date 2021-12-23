package de.goldenboys.housekeepingplanner.repository;

import de.goldenboys.housekeepingplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
