package com.example.todo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.entity.Todo;
import com.example.todo.entity.User;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);
}
