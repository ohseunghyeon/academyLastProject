package com.first.lastproject.command.board;

import org.springframework.ui.Model;

public class BoardSearchCommand implements BoardCommand {

	@Override
	public String execute(Model model) {
		
		
		
		return "board/boardSerch";
	}

}
