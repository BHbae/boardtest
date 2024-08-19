package com.tenco.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.board.repository.Interface.boardRepository;
import com.tenco.board.repository.model.Todo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	@Autowired
	private final boardRepository repository;

	@Transactional
	public List<Todo> readList(int page, int size) {
		List<Todo> list = null;
		int limit =size;
		int offset = (page -1) * size;

		list = repository.todoList(limit, offset);
		return list;
	}

	@Transactional
	public int insert(Todo todo) {
		int result = 0;
		result = repository.createTodo(todo);
		return result;
	}

	@Transactional
	public int delete(Integer id) {
		int result = 0;

		result = repository.deleteTodo(id);

		return result;
	}

	@Transactional
	public Todo readById(Integer id) {
		Todo todo = null;

		todo = repository.selectById(id);
		return todo;
	}

	public int updateByIdAndPaw(Integer id, String title, String content, Integer password) {
		int result = 0;

		result = repository.updateTodo(id, title, content, password);

		return result;

	}
	
	public int countBoards() {
		return repository.countBoard();
	}

	

}
