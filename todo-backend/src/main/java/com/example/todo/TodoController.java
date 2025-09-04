package com.example.todo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository repo;
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/{userId}")
    public List<Todo> getAllByUser(@PathVariable Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return repo.findByUser(user);
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repo.save(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        Todo existing = repo.findById(id).orElseThrow();
        existing.setTask(todo.getTask());
        existing.setCompleted(todo.isCompleted());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}