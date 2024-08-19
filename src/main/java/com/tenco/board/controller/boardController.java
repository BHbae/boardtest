package com.tenco.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.board.handler.exception.DataDeliveryException;
import com.tenco.board.repository.model.Todo;
import com.tenco.board.service.BoardService;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/todo")
public class boardController {

	@Autowired
	private BoardService boardService;

	// 주소 설계 : Http://localhost:8080/todo/list
	@GetMapping("/list")
	public String listTodo(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size, Model model) {

		int totalRecords = boardService.countBoards();

		int totalPages = (int) Math.ceil((double) totalRecords / size);

		List<Todo> list = boardService.readList(page, size);

		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("list", list);

		return "todo/todoList";
	}

	// 주소 설계 : Http://localhost:8080/todo/save
	@GetMapping("/save")
	public String saveTodo() {

		return "todo/todoSave";
	}

	@PostMapping("/save")
	public String postMethodName(Todo todo) {

		if (todo.getTitle() == null || todo.getTitle().isEmpty()) {
			throw new DataDeliveryException("제목을 입력해주세요", HttpStatus.BAD_REQUEST);

		}
		if (todo.getTitle().length() > 20) {
			throw new DataDeliveryException("제목의 길이는 20자를 넘길수 없습니다", HttpStatus.BAD_REQUEST);
		}

		if (todo.getContent().isEmpty() || todo.getContent().isEmpty()) {
			throw new DataDeliveryException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		if (todo.getContent().length() > 20) {
			throw new DataDeliveryException("내용의 길이는 20자를 넘길수 없습니다", HttpStatus.BAD_REQUEST);
		}

		boardService.insert(todo);

		return "redirect:/todo/list";
	}

	@GetMapping("/delete")
	public String getMethodName(@RequestParam(name = "id") Integer id, Model model) {


		model.addAttribute("id", id);

		return "todo/todoDelete";
	}

	@PostMapping("/delete")
	public String postMethodName(@RequestParam(name = "id") Integer id,
			@RequestParam(name = "password") Integer password) {

		Todo todo = boardService.readById(id);

		if (todo.getPassword() != password) {
			throw new DataDeliveryException("비밀번호가 틀렷습니다", HttpStatus.BAD_REQUEST);
		}
		boardService.delete(id);

		return "redirect:/todo/list";
	}

	@GetMapping("/update")
	public String getupdate(@RequestParam(name = "id") Integer id, Model model) {

		Todo todo = boardService.readById(id);

		model.addAttribute("todo", todo);

		return "todo/todoUpdate";
	}

	@PostMapping("/update")
	public String postUpdate(@RequestParam(name = "id") Integer id, @RequestParam(name = "title") String title,
			@RequestParam(name = "content") String content, @RequestParam(name = "password") Integer password) {

		Todo todo = boardService.readById(id);

		if (todo.getPassword() != password) {
			throw new DataDeliveryException("비밀번호가 틀렷습니다", HttpStatus.BAD_REQUEST);
		}

		if (title == null || title.isEmpty()) {
			throw new DataDeliveryException("제목을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if (title.length() > 20) {
			throw new DataDeliveryException("제목의 길이는 20자를 넘길수 없습니다", HttpStatus.BAD_REQUEST);
		}

		if (content.isEmpty() || content.isEmpty()) {
			throw new DataDeliveryException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}

		if (content.length() > 20) {
			throw new DataDeliveryException("내용의 길이는 20자를 넘길수 없습니다", HttpStatus.BAD_REQUEST);
		}

		boardService.updateByIdAndPaw(id, title, content, password);

		return "redirect:/todo/list";
	}

}
