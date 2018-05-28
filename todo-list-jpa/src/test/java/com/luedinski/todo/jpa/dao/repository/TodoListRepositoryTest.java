package com.luedinski.todo.jpa.dao.repository;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luedinski.todo.jpa.context.TodoListJPASpringConfiguration;
import com.luedinski.todo.jpa.dao.TodoList;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TodoListJPASpringConfiguration.class})
public class TodoListRepositoryTest {
	
	@Autowired
	private TodoListRepository subject;

	@Test
	public void testFindByName() throws Exception {
		TodoList todoList = new TodoList("test");
		TodoList save = subject.save(todoList);
		assertThat(save.getName()).isEqualTo("test");
	}

}
