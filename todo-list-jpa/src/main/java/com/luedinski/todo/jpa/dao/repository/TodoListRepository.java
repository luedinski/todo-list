package com.luedinski.todo.jpa.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.luedinski.todo.jpa.dao.TodoList;

public interface TodoListRepository extends CrudRepository<TodoList, Long> {

    List<TodoList> findByName(String name);
}
