package com.tenco.board.repository.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Todo {
	
	private int id;
	private String title;
	private String content;
	private String username;
	private Integer password;
	
}
