package cs4800.webscrape;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cs4800.event.Event;
import cs4800.service.EventService;

public class WebScrape {
    public static void main(String[] args) {
        Document doc = null;

        try {
            // need http protocol
            doc = Jsoup.connect("https://asi.cpp.edu/events/").get();

            for (Element e: doc.select("div.listing")) {
            	String name = e.selectFirst("div.listing a").text();
            	String info = e.selectFirst("div.listing-bottom").text();
            	
            	String date = info.substring(info.indexOf("DATE : ") + 7, info.indexOf(" TIME:"));
            	String time = info.substring(info.indexOf("TIME:") + 6, info.indexOf("LOCATION:"));
            	String location = info.substring(info.indexOf("LOCATION:") + 10, info.length());
            	
            	System.out.println(name);
            	System.out.println(date);
            	System.out.println(time);
            	System.out.println(location);
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
