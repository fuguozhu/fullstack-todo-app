package com.example.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean completed;
    private Long userId; // どのユーザーのToDoか

    // デフォルトコンストラクタ（JPA必須）
    public Todo() {
    }

    // コンストラクタ
    public Todo(String task, boolean completed, Long userId) {
        this.task = task;
        this.completed = completed;
        this.userId = userId;
    }

    // Getter/Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}