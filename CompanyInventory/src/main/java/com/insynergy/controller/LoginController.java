package com.insynergy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insynergy.form.LoginForm;
import com.insynergy.service.LoginService;



@Controller
public class LoginController {
	
	private LoginService loginService;
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setInventoryService(LoginService is){
		this.loginService = is;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model,HttpServletRequest request,Model modelone) {

		
		if (result.hasErrors()) {
			  modelone.addAttribute("message", "please enter  valid Username and Password ");
			return "loginform";
		}
		
		/*
		String userName = "UserName";
		String password = "password";
		loginForm = (LoginForm) model.get("loginForm");
		if (!loginForm.getUserName().equals(userName)
				|| !loginForm.getPassword().equals(password)) {
			return "loginform";
		}
		*/
		boolean userExists = loginService.login(loginForm.getUserName(),
                loginForm.getPassword());
		
		if(userExists){
			model.put("loginForm", loginForm);
			
            HttpSession session=request.getSession();
            session.setAttribute("uname",loginForm.getUserName());
            session.setAttribute("pwd",loginForm.getPassword());
            modelone.addAttribute("user", "asdf");
			return "redirect:/inventories";
		}else{
			result.rejectValue("userName","invaliduser");
			modelone.addAttribute("message", "Please enter valid Username and Password ");
			return "loginform";
		}

	}

	
	@RequestMapping(value = "/logout/inventory",method = RequestMethod.POST)
	public String logout(Map model,HttpServletRequest request) {

		
		
            HttpSession session=request.getSession();
            System.out.println("Logout user Name :"+session.getAttribute("uname"));
            System.out.println("Logout PWD : "+session.getAttribute("pwd"));
            session.setAttribute("uname","");
            session.setAttribute("pwd","");
          
			return "redirect:loginform";
		

	}

   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "inventoryList";
    }
   
   
   
   
}
    

    
