package de.goldenboys.housekeepingplanner.repository;

import de.goldenboys.housekeepingplanner.model.Task;
import de.goldenboys.housekeepingplanner.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByAssignedTo(User user);
}
