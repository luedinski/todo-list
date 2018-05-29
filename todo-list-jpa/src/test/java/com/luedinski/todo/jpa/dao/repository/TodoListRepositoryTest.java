package com.luedinski.todo.jpa.dao.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luedinski.todo.jpa.context.TodoListJPASpringConfiguration;
import com.luedinski.todo.jpa.dao.Task;
import com.luedinski.todo.jpa.dao.TodoList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TodoListJPASpringConfiguration.class })
public class TodoListRepositoryTest {

	@Autowired
	private TodoListRepository subject;
	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void testPersist() throws Exception {
		TodoList todoList = new TodoList("test");
		TodoList save = subject.save(todoList);
		assertThat(save.getName()).isEqualTo("test");
		assertThat(save.getTasks()).isNull();

		Task task = new Task("Do something cool");
		task.setTodoList(todoList);
		save.setTasks(Collections.singletonList(task));
		subject.save(save);
		Optional<TodoList> changed = subject.findById(save.getId());
		assertThat(changed).isPresent();
		List<Task> tasks = changed.get().getTasks();
		Task savedTask = tasks.get(0);
		assertThat(savedTask.getName()).isEqualTo("Do something cool");
	}

}
