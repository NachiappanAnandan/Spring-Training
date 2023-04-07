package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello () {
		System.out.println("Hello Welcome to Spring MVC....");
	}
	
	@RequestMapping(value = "hello2" , method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("Say Hello 2 method is called");
		return "Welcome";
	}
	
	@RequestMapping(value = "hello3" , method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3(){
		return ResponseEntity.ok("This is a responsee entity.");
	}
	
	@RequestMapping(value = "hello4" , method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "this is a value for model and view ");
		mv.setViewName("Welcome");
		return mv;
	}
	
	@RequestMapping(value = "hello5" , method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mv) {
		mv.addObject("key", "this is a value for model and view ");
		mv.setViewName("Welcome");
		return mv;
	}
	
	@RequestMapping(value = "hello6" , method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mv , HttpServletRequest request) {
		mv.addObject("key" , "this i value of add object");
		HttpSession session = request.getSession();
		request.setAttribute("key1", "this is value of request attribute");
		session.setAttribute("sessionKey","This is a value of session object in hello 6 ......");
		mv.setViewName("Welcome");
		return mv;
	}
	
	@RequestMapping(value  = "repeat" , method =  RequestMethod.GET)
	public ModelAndView repeat(ModelAndView mv) {
		mv.addObject("key" , "This is a request value for repeat....");
		mv.setViewName("Welcome");
		return mv;
	}
	
	
	@RequestMapping(value = "passuser1" , method = RequestMethod.GET)
	public ResponseEntity<user> passUser1(){
		user user = new user("raja" , 1);
		return ResponseEntity.ok(user);
		
	}
	
	@RequestMapping(value = "passuser2" , method = RequestMethod.POST)
	public ResponseEntity<user> passUser2(@RequestBody user user){
		System.out.println(user);
		user.setId(user.getId()+2);
		user.setName(user.getName()+"changed");
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = "passuser3" , method = RequestMethod.POST)
	public user passUser3(@RequestBody user user){
		System.out.println(user);
		user.setId(user.getId()+2);
		user.setName(user.getName()+"changed");
		return user;
	}
	
	
	
}

class user{
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public user(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}