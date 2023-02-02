package com.cjc.co.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjc.co.model.Employee;
import com.cjc.co.servicei.Servicei;


@Controller
public class HomeController {                          // old way
     
	@Autowired
	Servicei si;
	                                                //  web.xml (DispatcherServlet) >>> index.jsp
	@RequestMapping("/")
	public String preLogin()
	{                                             //  web.xml (DispatcherServlet) >>> handlerMapping  >>>  HomeController >>> viewResolver >>> login.jsp
		return "login";                          //  "login"  >>>> viewResolver >>>> will search login.jsp in given prefix path
	}
//----------------------------------------------------------------------
	@RequestMapping("/register")
	public String preRegister()
	{
		return "register";
	}

//------------------------------------------------------------------------	
	@RequestMapping("/login")
	public String login(@ModelAttribute Employee e, Model m)
	{
		if(e.getUsername().equals("admin") && e.getPassword().equals("admin"))
		{
			m.addAttribute("Data",si.getAll());
			return "success";
		}
		
		else
		{
			if(!si.loginUser(e).isEmpty())
			{
				m.addAttribute("Data",si.loginUser(e));
				return "success";
			}
			else
			{
				System.out.println("Invalid Username or Password...!!!");
				return "login";
			}
		}
	}

//-----------------------------------------------------------------------	
	@RequestMapping("/registerUser")
	public String register(@ModelAttribute Employee e)
	{
		

		
//		System.out.println(e.getAddr().getCity());
		
		int id = si.saveUser(e);
		
		if(id > 0)
		{
			System.out.println("Data Inject Successfully...!!!");
			return "login";
		}
		else 
		{
			System.out.println("Something Went Wrong...!!!");
			return "register";
		}	
	}
//-------------------------------------------------------------------------	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute Employee e,Model m) 
	{
		int id = e.getId();
		si.deleteUser(id);
		m.addAttribute("Data",si.getAll());
		return "success";
	}

//---------------------------------------------------------------
		@RequestMapping("/edit")
		public String preEdit(@ModelAttribute Employee e, Model m)
		{
			int id = e.getId();
			m.addAttribute("emp",si.getUser(id));
			return "edit";
		}
//-----------------------------------------------------------------
		@RequestMapping("/update")
		public String update(@ModelAttribute Employee e,Model m)
		{
			si.updateUser(e);
			
			
			
			m.addAttribute("Data",si.getAll());
			return "success";
		}

		
	@RequestMapping("*")
	public String error()
	{
		return "error";
	}
}
