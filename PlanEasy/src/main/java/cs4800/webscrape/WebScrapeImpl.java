package cs4800.webscrape;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.lang.Object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import cs4800.service.EventService;
import cs4800.event.Event;

@Component
public class WebScrapeImpl implements WebScrape {
	
	private static final Logger log = Logger.getLogger(WebScrapeImpl.class.getName());
	
	@Value("${asi-link1}")
	private String asiLink1;
	@Value("${asi-link2}")
	private String asiLink2;
	@Value("${career-center-link}")
	private String careerCenterLink;
	@Value("${general-event-link1}")
	private String generalLink1;
	@Value("${general-event-link2}")
	private String generalLink2;
	@Autowired
	private EventService service;
	
	@Override
	public List<Event> loadData() throws IOException {
		Document doc = Jsoup.connect(asiLink1).get();
		
		for (Element e: doc.select("div.listing")) {
        	String name = e.select("h4 a").text();
        	String info = e.select("span").text();
        	
        	String date = info.substring(info.indexOf("DATE : ") + 7, info.indexOf(" TIME:"));
        	String time = info.substring(info.indexOf("TIME:") + 6, info.indexOf("LOCATION:"));
        	String location = "Cal Poly Pomona: " + info.substring(info.indexOf("LOCATION:") + 10, info.length());
        	
        	String startTime = getStartTime(time);
        	String endTime = getEndTime(time);
        	
        	
        	if (!eventAlreadyExists(name, date, startTime, endTime)) {
        		Event event = new Event(name, date, date, startTime, endTime, location, "ASI");
        		service.addEvent(event);
        	}
        	
		}
		
		doc = Jsoup.connect(asiLink2).get();
		for (Element e: doc.select("div.listing")) {
        	String name = e.select("h4 a").text();
        	String info = e.select("span").text();
        	
        	String date = info.substring(info.indexOf("DATE : ") + 7, info.indexOf(" TIME:"));
        	String time = info.substring(info.indexOf("TIME:") + 6, info.indexOf("LOCATION:"));
        	String location = "Cal Poly Pomona: " + info.substring(info.indexOf("LOCATION:") + 10, info.length());
        	
        	String startTime = getStartTime(time);
        	String endTime = getEndTime(time);
        	
        	
        	if (!eventAlreadyExists(name, date, startTime, endTime)) {
        		Event event = new Event(name, date, date, startTime, endTime, location, "ASI");
        		service.addEvent(event);
        	}
        	
		}
		
		doc = Jsoup.connect(careerCenterLink).get();
		for (Element e: doc.select("tr + tr")) {
			String name = e.select("td.cpp_dark_eggplant_font").text();
			String dateInfo = e.select("td.cpp_green_font").text();
			String timeInfo = e.select("td.cpp_dark_eggplant_font + td").text();
			String location = "Cal Poly Pomona: " + e.select("td.cpp_dark_eggplant_font + td + td").text();
			
			String date = dateInfo.substring(dateInfo.indexOf(" ") + 1, dateInfo.length());
			String startTime = "0:00 AM";
			String endTime = "0:00 AM";
			
			if (!timeInfo.equals("TBA")) {
				startTime = timeInfo.substring(0, timeInfo.indexOf("-"));
				endTime = timeInfo.substring(timeInfo.indexOf("-") + 1, timeInfo.length());
				if (!Character.isWhitespace(endTime.charAt(endTime.length()-3)))
					endTime = endTime.substring(0, endTime.length() - 2) + " " + endTime.substring(endTime.length() - 2, endTime.length());
			}
				
			
			if (!eventAlreadyExists(name, date, startTime, endTime)) {
        		Event event = new Event(name, date, date, startTime, endTime, location, "Career Center");
        		service.addEvent(event);
			}
			
		}
		
		doc = Jsoup.connect(generalLink1).get();
		for (Element e: doc.select("div.event")) {
			String name = e.select("h3").text();
			String dateInfo = e.select("h4").text();
			String date = dateInfo.substring(dateInfo.indexOf(" ") + 1, dateInfo.length());
			date = date.substring(0, date.indexOf(",") + 6);
			
			String description = e.select("p").text();
			String startTime = description.substring(0,description.indexOf("to") - 1);
			String endTime = description.substring(description.indexOf("to") + 3, description.indexOf("-") - 1);
			
			String location = "Cal Poly Pomona: ";
			
			description = description.substring(description.indexOf("-") + 2, description.length());
			
			if (description.equals("Music Recital Hall")) {
				location += description;
				if (!eventAlreadyExists(name, date, startTime, endTime)) {
	        		Event event = new Event(name, date, date, location);
	        		event.setStartTime(startTime);
	        		event.setEndTime(endTime);
	        		service.addEvent(event);
				}
			}
			else {
				location += description.substring(0, description.indexOf(":"));
				description = description.substring(description.indexOf(":") + 2, description.length());
				if (!eventAlreadyExists(name, date, startTime, endTime)) {
	        		Event event = new Event(name, date, date, location);
	        		event.setDescription(description);
	        		event.setStartTime(startTime);
	        		event.setEndTime(endTime);
	        		service.addEvent(event);
				}
        	}
        	
		}
		
		doc = Jsoup.connect(generalLink2).get();
		for (Element e: doc.select("div.event")) {
			String name = e.select("h3").text();
			String dateInfo = e.select("h4").text();
			String date = dateInfo.substring(dateInfo.indexOf(" ") + 1, dateInfo.length());
			date = date.substring(0, date.indexOf(",") + 6);
			
			String description = e.select("p").text();
			String startTime = description.substring(0,description.indexOf("to") - 1);
			String endTime;
			
			String location = "Cal Poly Pomona: ";
			
			/*
			if (name.equals("28th Unity Luncheon") &&
					!(description.equals("Music Recital Hall") || description.equals("University Theatre") || description.equals("Engineering Neighborhood"))) {
				location = "Cal Poly Pomona";
				description = description.substring(description.indexOf("The"), description.length());
				endTime = description.substring(description.indexOf("to") + 3, description.indexOf("The") - 3);
				
				if (!eventAlreadyExists(name, date, startTime, endTime)) {
					Event event = new Event(name);
					event.setStartDate(date);
					event.setEndDate(date);
					event.setStartTime(startTime);
					event.setEndTime(endTime);
					event.setLocation(location);
					event.setDescription(description);
				}
			}*/
			
			if ((description.equals("Music Recital Hall") || description.equals("University Theatre") || description.equals("Engineering Neighborhood"))
					&& !name.equals("28th Unity Luncheon")) {
				description = description.substring(description.indexOf("-") + 2, description.length());
				location += description;
				endTime = description.substring(description.indexOf("to") + 3, description.indexOf("-") - 1);
				if (!eventAlreadyExists(name, date, startTime, endTime)) {
	        		Event event = new Event(name, date, date, location);
	        		event.setStartTime(startTime);
	        		event.setEndTime(endTime);
	        		service.addEvent(event);
				}
			}
			/*
			else if (!name.equals("28th Unity Luncheon") && 
					!(description.equals("Music Recital Hall") || description.equals("University Theatre") || description.equals("Engineering Neighborhood"))) {
				endTime = description.substring(description.indexOf("to") + 3, description.indexOf("-") - 1);
				description = description.substring(description.indexOf("-") + 2, description.length());
				location += description.substring(0, description.indexOf(":"));
				description = description.substring(description.indexOf(":") + 2, description.length());
				
				if (!eventAlreadyExists(name, date, startTime, endTime)) {
	        		Event event = new Event(name, date, date, location);
	        		event.setDescription(description);
	        		event.setStartTime(startTime);
	        		event.setEndTime(endTime);
	        		service.addEvent(event);
				}
        	}*/
        	
		}
		
        	log.info("Webscraping events into database...");
        	log.info(service.getAllEvents().toString());
        	return service.getAllEvents();
	} 
	
	private String getStartTime(String time) {

		if(time.contentEquals("All day event "))
			return "7:00 AM";
		else
			return time.substring(0, time.indexOf(" - ") - 2) + time.substring(time.indexOf(" - ") - 2, time.indexOf(" - ")).toUpperCase();
	}
	
	private String getEndTime(String time) {
		
		if(time.contentEquals("All day event "))
			return "4:00 PM";
		else
			return time.substring(time.indexOf(" - ") + 3, time.length() - 3) + time.substring(time.length() - 3, time.length() - 1).toUpperCase();
	}
	
	private boolean eventAlreadyExists(String name, String date, String startTime, String endTime) {
		boolean found = false;
		
		for (Event e : service.getAllEvents()) {
			DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
			LocalDate startDate = LocalDate.parse(date, formatDate);
			
			DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("h:mm a");
			LocalTime localStartTime = LocalTime.parse(startTime, formatTime);
			LocalTime localEndTime = LocalTime.parse(endTime, formatTime);
			
			
			if (e.getName().equals(name) &&
					e.getStartDate().equals(startDate) &&
					e.getStartTime().equals(localStartTime) &&
					e.getEndTime().equals(localEndTime))
				found = true;
				
		}
		
		return found;
	}
	
}
