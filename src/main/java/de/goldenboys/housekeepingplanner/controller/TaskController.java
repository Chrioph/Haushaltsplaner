package de.goldenboys.housekeepingplanner.controller;

import de.goldenboys.housekeepingplanner.model.Task;
import de.goldenboys.housekeepingplanner.model.User;
import de.goldenboys.housekeepingplanner.repository.TaskRepository;
import de.goldenboys.housekeepingplanner.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskController(TaskRepository tr, UserRepository ur) {
        this.taskRepository = tr;
        this.userRepository = ur;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        task.id = null;
        task = taskRepository.save(task);
        return ResponseEntity.created(URI.create("/tasks/" + task.id)).body(task);
    }

    @GetMapping
    public Iterable<Task> getProfiles() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> maybeTask = taskRepository.findById(id);
        if (maybeTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(maybeTask.get());
    }

    @GetMapping("/user/{userId}")
    public Iterable<Task> getTasksByProfile(@PathVariable Long userId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if(maybeUser.isEmpty()) {
            return Collections.emptyList();
        }
        return taskRepository.findAllByAssignedTo(maybeUser.get());
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        if(task.id != null && task.id != id) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        HttpStatus status = task.id == null ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(taskRepository.save(task));
    }
}
