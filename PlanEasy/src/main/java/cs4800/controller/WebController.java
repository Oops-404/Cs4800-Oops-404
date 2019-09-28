package cs4800.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import cs4800.event.Event;
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
	

	@RequestMapping(value = "/test/event", method = RequestMethod.GET)
	String eventTest() {
		Event event = new Event("test event");
		
		event.setStartDate(29, 06, 2019);
		event.setStartTime(14, 30, 00);
		event.setEndDate(30, 06, 2019);
		event.setEndTime(16, 50, 05);
		
		return event.toString();
	}

	//test Gson
	@RequestMapping(value = "/gson", method = RequestMethod.GET)
	String testGson(){
		String[] strings = {"test", "-ing", "gson"};
		Gson gson = new Gson();
		
		return gson.toJson(strings);
	}
}