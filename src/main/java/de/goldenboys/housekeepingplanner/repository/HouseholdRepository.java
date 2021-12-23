package de.goldenboys.housekeepingplanner.repository;

import de.goldenboys.housekeepingplanner.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
}
