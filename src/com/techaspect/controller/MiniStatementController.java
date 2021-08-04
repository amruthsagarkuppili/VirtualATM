package com.techaspect.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.techaspect.atm.service.atmService;
import com.techaspect.atm.to.User;

@Controller
public class MiniStatementController {
	atmService atmservice;
	
	@Autowired
	public MiniStatementController(atmService atmservice) {
		this.atmservice = atmservice;
	}

@RequestMapping(value = "/MiniStatement")
public String Ministatement(HttpSession session) {
	
	User user =(User) session.getAttribute("User");
	user = atmservice.MiniStatement( user);
	
	session.setAttribute("User", user);
	return "MiniStatement.jsp";
}
	


/*	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = null;
		
		HttpSession session = req.getSession();	
		User user =(User) session.getAttribute("User");
		user = atmserviceinterface.MiniStatement( user);
		
		session.setAttribute("User", user);
		modelAndView = new ModelAndView("MiniStatement.jsp");
		return modelAndView;
	}*/

}
