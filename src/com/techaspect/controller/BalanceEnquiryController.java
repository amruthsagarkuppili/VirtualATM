package com.techaspect.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;



import com.techaspect.atm.service.atmService;
import com.techaspect.atm.to.User;

@Controller
public class BalanceEnquiryController{
	atmService atmservice;
	
	@Autowired
	public BalanceEnquiryController(atmService atmservice) {
		this.atmservice = atmservice;
	}

@RequestMapping(value =  "/BalanceEnquiry")
public String BalanceInfo(HttpSession session) {
	User user =(User) session.getAttribute("User");
	user = atmservice.BalanceEnquiry(user);
	
	session.setAttribute("User", user);
	return "BalanceEnquiry.jsp";
	
}
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = null;		
		
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("User");
		user = atmserviceinterface.BalanceEnquiry(user);
		
		session.setAttribute("User", user);
		modelAndView = new ModelAndView("BalanceEnquiry.jsp");
		return modelAndView;
	}*/


	

}
