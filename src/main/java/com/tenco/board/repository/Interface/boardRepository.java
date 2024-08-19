package com.tenco.board.repository.Interface;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.board.repository.model.Todo;

@Mapper
public interface boardRepository {
	
	public List<Todo> todoList(@Param("limit") int limit
			,@Param("offset") int offset);
	
	public int createTodo(Todo todo);
	
	public int deleteTodo(@Param("id") Integer id);
	
	public Todo selectById(@Param("id") Integer id);
	
	public int updateTodo(@Param("id")Integer id,
			@Param("title") String title,
			@Param("content") String content,
			@Param("password") Integer password);
	
	public int countBoard();
	

}
