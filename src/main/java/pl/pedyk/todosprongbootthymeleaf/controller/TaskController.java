package pl.pedyk.todosprongbootthymeleaf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pedyk.todosprongbootthymeleaf.model.Task;
import pl.pedyk.todosprongbootthymeleaf.model.TaskRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/tasks", params = {"!sort", "!page", "!size"})
        //client wchodzi w tą metode tylko gdy nie ma parametrów
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(path = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Custom pageable!");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @GetMapping(path = "/tasks/{id}")
    ResponseEntity<Task> readSelectedTask(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task taskToCreate) {
        Task result = repository.save(taskToCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
