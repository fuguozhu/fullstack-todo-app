package com.example.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user); // ユーザーごとのToDo取得
}