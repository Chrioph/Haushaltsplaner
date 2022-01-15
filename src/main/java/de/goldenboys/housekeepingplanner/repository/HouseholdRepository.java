package de.goldenboys.housekeepingplanner.repository;

import de.goldenboys.housekeepingplanner.model.Household;
import de.goldenboys.housekeepingplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    List<Household> findAllByUsersContaining(User user);
}
