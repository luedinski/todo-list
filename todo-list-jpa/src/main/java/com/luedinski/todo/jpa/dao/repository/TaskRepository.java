package com.luedinski.todo.jpa.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.luedinski.todo.jpa.dao.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
