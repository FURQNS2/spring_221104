package com.sycompany.std23;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sycompany.std23.dao.ContentDao;
import com.sycompany.std23.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	ContentDao dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	
		return "redirect:list";
	}
	
	

	public void setDao(ContentDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/writeForm")
	public String WriteForm() {
		return "writeForm";
	}
	
	
	@RequestMapping("/write")
	public String Write(HttpServletRequest request) {
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		dao.writeDao(mwriter, mcontent);		
		
		return "redirect:list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		
		ArrayList<ContentDto> dtos = dao.listDao();
		
		model.addAttribute("list", dtos);
		
		return "list";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "redirect:list";
	
	}
	
}
