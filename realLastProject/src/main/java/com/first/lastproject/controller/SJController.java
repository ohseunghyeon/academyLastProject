package com.first.lastproject.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.board.BoardCommand;
import com.first.lastproject.command.board.BoardContentFormCommand;
import com.first.lastproject.command.board.BoardDeleteFormCommand;
import com.first.lastproject.command.board.BoardDeleteProCommand;
import com.first.lastproject.command.board.BoardListCommand;
import com.first.lastproject.command.board.BoardModifyFormCommand;
import com.first.lastproject.command.board.BoardModifyProCommand;
import com.first.lastproject.command.board.BoardModifyViewCommand;
import com.first.lastproject.command.board.BoardSearchCommand;
import com.first.lastproject.command.board.BoardWriteFormCommand;
import com.first.lastproject.command.board.BoardWriteProCommand;
import com.first.lastproject.command.member.MemberCommand;
import com.first.lastproject.command.member.MemberCouponFormCommand;
import com.first.lastproject.command.stock.StockCommand;
import com.first.lastproject.command.stock.StockFoodModifyProCommand;
import com.first.lastproject.command.stock.StockListCommand;
import com.first.lastproject.command.stock.StockIngredientModifyProCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SJController {

	@RequestMapping("/ingredient")
	public String ingredient(HttpServletRequest request, Model model) {
		System.out.println("ingredient()");

		model.addAttribute("request", request);
		StockCommand command = new StockListCommand();
		String viewname = command.execute(model);

		return viewname;
	}

	@RequestMapping("/ingredientModifyForm")
	public String modifyForm(Model model) {
		System.out.println("ingredientModifyForm()");
		return "host/stock/ingredientModifyForm";
	}

	@RequestMapping("/ingredientModifyPro")
	public String stockIngredientModifyPro(HttpServletRequest request, Model model) {
		System.out.println("ingredientModifyPro()");

		model.addAttribute("request", request);
		StockCommand command = new StockIngredientModifyProCommand();
		String viewname = command.execute(model);

		return viewname;
	}

	@RequestMapping("/foodModifyForm")
	public String foodModifyForm(Model model) {
		System.out.println("foodModifyForm()");
		return "host/stock/foodModifyForm";
	}
	@RequestMapping("/Home")
	public String home(Model model) {
		System.out.println("home()");
		return "member/Home";
	}

	@RequestMapping("/foodModifyPro")
	public String foodModifyPro(HttpServletRequest request, Model model) {
		System.out.println("foodmodifyPro()");

		model.addAttribute("request", request);
		StockCommand command = new StockFoodModifyProCommand();
		String viewname = command.execute(model);

		return viewname;
	}

	//여기부터 게시판 
	
	
	@Autowired
	BoardListCommand boardListCommand;
	@RequestMapping("/boardList")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("boardList()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardListCommand();
		String viewname = boardListCommand.execute(model);

		return viewname;
	}

	@Autowired
	BoardWriteFormCommand boardWriteFormCommand;
	@RequestMapping("/writeForm")
	public String writeForm(HttpServletRequest request, Model model) {
		System.out.println("writeForm()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardWriteFormCommand();
		String viewname = boardWriteFormCommand.execute(model);

		return viewname;
	}

	@Autowired
	BoardWriteProCommand boardWriteProCommand;
	@RequestMapping("/writePro")
	public String writePro(HttpServletRequest request, Model model) {
		System.out.println("writePro()");
		
		model.addAttribute("request", request);
		//BoardCommand command = new BoardWriteProCommand();
		String viewname = boardWriteProCommand.execute(model);

		return viewname;
	}
	
	@Autowired
	BoardContentFormCommand boardContentFormCommand;
	@RequestMapping("/contentForm")
	public String contentForm(HttpServletRequest request, Model model) {
		System.out.println("contentForm()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardContentFormCommand();
		String viewname = boardContentFormCommand.execute(model);

		return viewname;

	}
	@Autowired
	BoardDeleteFormCommand boardDeleteFormCommand;
	@RequestMapping("/deleteForm")
	public String deleteForm(HttpServletRequest request, Model model) {
		System.out.println("deleteForm()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardDeleteFormCommand();
		String viewname = boardDeleteFormCommand.execute(model);

		return viewname;

	}

	@Autowired
	BoardDeleteProCommand boardDeleteProCommand;
	@RequestMapping("/deletePro")
	public String deletePro(HttpServletRequest request, Model model) {
		System.out.println("deletePro()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardDeleteProCommand();
		String viewname = boardDeleteProCommand.execute(model);

		return viewname;

	}

	@Autowired
	BoardModifyFormCommand boardModifyFormCommand;
	@RequestMapping("/boardModifyForm")
	public String boardModifyForm(HttpServletRequest request, Model model) {
		System.out.println("boardModifyForm()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardModifyFormCommand();
		String viewname = boardModifyFormCommand.execute(model);

		return viewname;

	}

	@Autowired
	BoardModifyViewCommand boardModifyViewCommand;
	@RequestMapping("/boardModifyView")
	public String boardModifyView(HttpServletRequest request, Model model) {
		System.out.println("modifyView()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardModifyViewCommand();
		String viewname = boardModifyViewCommand.execute(model);

		return viewname;

	}
	@Autowired
	BoardModifyProCommand boardModifyProCommand;
	@RequestMapping("/boardModifyPro")
	public String boardModifyPro(HttpServletRequest request, Model model) {
		System.out.println("modifyPro()");

		model.addAttribute("request", request);
		//BoardCommand command = new BoardModifyProCommand();
		String viewname = boardModifyProCommand.execute(model);

		return viewname;

	}
	
	@Autowired
	BoardSearchCommand boardSearchCommand;
	@RequestMapping("/boardSearch")
	public String boardSerch(HttpServletRequest request,Model model) {
		System.out.println("boardSerch()");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("request", request);
		//BoardCommand command = new BoardSearchCommand();
		String viewname = boardSearchCommand.execute(model);
		
		
		return viewname;
	}
	
	//여기부터 쿠폰
	@RequestMapping("/coupon")
	public String coupon(HttpServletRequest request, Model model) {
		System.out.println("coupon()");

		model.addAttribute("request", request);
		MemberCommand command = new MemberCouponFormCommand();
		String viewname = command.execute(model);

		return viewname;

	}
	@RequestMapping("/guestHeader")
	public String guestHeader(Model model) {
		System.out.println("guestHeader()");
		return "/menu/guestHeader";
	}
	@RequestMapping("/noMeberHeader")
	public String noMeberHeader(Model model) {
		System.out.println("noMeberHeader()");
		return "/menu/noMeberHeader";
	}
	@RequestMapping("/hostHeader")
	public String hostHeader(Model model) {
		System.out.println("hostHeader()");
		return "/menu/hostHeader";
	}
	@RequestMapping("/guestFooter")
	public String guestFooter(Model model) {
		System.out.println("guestFooter()");
		return "/menu/guestFooter";
	}
	@RequestMapping("/noMeberFooter")
	public String noMeberFooter(Model model) {
		System.out.println("noMeberFooter()");
		return "/menu/noMeberFooter";
	}
	@RequestMapping("/hostFooter")
	public String hostFooter(Model model) {
		System.out.println("hostFooter()");
		return "/menu/hostFooter";
	}

	@RequestMapping("/couponmain")
	public String couponmain(Model model) {
		System.out.println("couponmain()");
		return "/member/p_coupon/couponmain";
	}


}
