package cs4800.webscrape;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cs4800.service.EventService;
import cs4800.event.Event;

@Component
public class WebScrapeImpl implements WebScrape{
	
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
        	String location = info.substring(info.indexOf("LOCATION:") + 10, info.length());
        	
        	String startTime = getStartTime(time);
        	String endTime = getEndTime(time);
        	
        	Event event = new Event(name, date, date, startTime, endTime, location, "ASI");
        	
        	service.save(event);
        	
		}
        	System.out.println(service.getAllEvent());
        	return service.getAllEvent();
	} 
	
	private String getStartTime(String time) {

		if(time.contentEquals("All day event "))
			return "7:00 am";
		else
			return time.substring(0, time.indexOf(" - "));
	}
	
	private String getEndTime(String time) {
		
		if(time.contentEquals("All day event "))
			return "4:00 pm";
		else
		return time.substring(time.indexOf(" - ") + 3, time.length());
	}
	
}
