package cs4800.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs4800.calendar.Calendar;
import cs4800.event.Event;
import cs4800.user.User;
import com.google.gson.Gson;
import java.util.List;
import java.time.DayOfWeek;

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
	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	List<DayOfWeek> eventTest() {
		Calendar cal = new Calendar();
		cal.setMonth(6);
		return cal.getCalendarMonth();
	}

	//test Gson
	@RequestMapping(value = "/gson", method = RequestMethod.GET)
	String testGson(){
		String[] strings = {"test", "-ing", "gson"};
		Gson gson = new Gson();
		
		return gson.toJson(strings);
	}
}