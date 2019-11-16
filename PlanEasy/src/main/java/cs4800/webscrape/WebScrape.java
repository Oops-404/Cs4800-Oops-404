package cs4800.webscrape;

import java.io.IOException;
import java.util.List;

import cs4800.event.Event;
 
public interface WebScrape {
	
    List<Event> loadData() throws IOException;
}
