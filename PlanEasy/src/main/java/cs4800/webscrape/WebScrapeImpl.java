package cs4800.webscrape;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

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
	
	@Value("${link}")
	private String link;
	@Autowired
	private EventService service;
	
	@Override
	public List<Event> loadData() throws IOException {
		Document doc = Jsoup.connect(link).get();
		
		for (Element e: doc.select("div.listing")) {
        	String name = e.select("h4 a").text();
        	String info = e.select("span").text();
        	
        	String date = info.substring(info.indexOf("DATE : ") + 7, info.indexOf(" TIME:"));
        	String time = info.substring(info.indexOf("TIME:") + 6, info.indexOf("LOCATION:"));
        	String location = "Cal Poly Pomona: " + info.substring(info.indexOf("LOCATION:") + 10, info.length());
        	
        	String startTime = getStartTime(time);
        	String endTime = getEndTime(time);
        	
        	Event event = new Event(name, date, date, startTime, endTime, location, "ASI");
        	
        	if (!eventAlreadyExists(event))
        		service.addEvent(event);
        	
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
	
	private boolean eventAlreadyExists(Event event) {
		if (service.getAllEvents().contains(event))
			return true;
		else
			return false;
	}
	
}
