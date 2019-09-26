package cs4800.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;




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
	
	//test Gson
	@RequestMapping(value = "/gson", method = RequestMethod.GET)
	String testGson(){
		String[] strings = {"test", "-ing", "gson"};
		Gson gson = new Gson();
		
		return gson.toJson(strings);
	}
}