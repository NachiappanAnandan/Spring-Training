package com.example.demo;


/**
 * @author Nachiappan
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	/**
	 * functio to rpint a spring using route
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello () {
		System.out.println("Hello Welcome to Spring MVC....");
	}
	/** 
	 * Function returns a string of view name
	 * 
	 * @return string of view name
	 */
	@RequestMapping(value = "hello2" , method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("Say Hello 2 method is called");
		return "Welcome";
	}
	
	/**
	 *  Function return a reponse entity
	 *  
	 * @return Response Entity
	 */
	@RequestMapping(value = "hello3" , method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3(){
		return ResponseEntity.ok("This is a responsee entity.");
	}
	
	/**
	 *  Function to access model and view
	 * @return model and view
	 */
	
	@RequestMapping(value = "hello4" , method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", "this is a value for model and view ");
		mv.setViewName("Welcome");
		return mv;
	}
	/**
	 * Function to access model and view
	 * 
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(value = "hello5" , method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mv) {
		mv.addObject("key", "this is a value for model and view ");
		mv.setViewName("Welcome");
		return mv;
	}
	
	/**
	 * To access the request and session values
	 * 
	 * @param mv
	 * @param request
	 * @return model and view
	 */
	@RequestMapping(value = "hello6" , method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mv , HttpServletRequest request) {
		mv.addObject("key" , "this i value of add object");
		HttpSession session = request.getSession();
		request.setAttribute("key1", "this is value of request attribute");
		session.setAttribute("sessionKey","This is a value of session object in hello 6 ......");
		mv.setViewName("Welcome");
		return mv;
	}
	
	/**
	 * access the session value stored
	 * 
	 * @param mv
	 * @return model and view
	 */
	@RequestMapping(value  = "repeat" , method =  RequestMethod.GET)
	public ModelAndView repeat(ModelAndView mv) {
		mv.addObject("key" , "This is a request value for repeat....");
		mv.setViewName("Welcome");
		return mv;
	}
	
	
	/**
	 * Returns a object in response entity
	 * 
	 * @return response entity
	 */
	@RequestMapping(value = "passuser1" , method = RequestMethod.GET)
	public ResponseEntity<user> passUser1(){
		user user = new user("raja" , 1);
		return ResponseEntity.ok(user);
		
	}
	
	/**
	 * Access from body and return a response entity
	 * 
	 * @param user
	 * @return response entity
	 */
	@RequestMapping(value = "passuser2" , method = RequestMethod.POST)
	public ResponseEntity<user> passUser2(@RequestBody user user){
		System.out.println(user);
		user.setId(user.getId()+2);
		user.setName(user.getName()+"changed");
		return ResponseEntity.ok(user);
	}
	
	/**
	 * 
	 * The function returns a object itself using rest controller 
	 * 
	 * @param user
	 * @return object
	 */
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