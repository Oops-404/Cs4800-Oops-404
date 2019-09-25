package cs4800.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class WebController {

	

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	String healthCheck() {
	
		return "OK";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	String homePage(){
		return "This is the home page";
	}
}