package cs4800.database;

import static com.mongodb.client.model.Filters.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/*
 * Database class contains all functions regarding queries and 
 * manipulation of data in the Oops404 database.
 * 
 */
public class Database {
	
	private static final Logger log = Logger.getLogger(Database.class.getName());

	private static String URI = "mongodb+srv://admin:Oops!404@oops404-ijzpy.azure.mongodb.net/Event?retryWrites=true&w=majority";
	private static MongoClient mongoClient = null;
	private static MongoDatabase db = null;
	
	private static MongoCollection<Document> event = null;
	private static MongoCollection<Document> user = null;
	
	public Database() {	}
	
	/**
	 * Initialize connection to MongoDB server, access Oops404 database, 
	 * and initialize each collection in the database
	 * 
	 */
	public void connect() {
		
		try {
			mongoClient = new MongoClient(new MongoClientURI(URI));
			log.info("Connected to MongoDB :)");
			db = mongoClient.getDatabase("Oops404");
			event = db.getCollection("Event");
			user = db.getCollection("User");
		} 
		
		catch (MongoException e) {
        	log.log(Level.SEVERE, "Not connected to MongoDB :(", e);
		}
	}
	
	/**
	 * Query event by their location
	 * @param userEntered string entered by user
	 */
	public void selectEventByLocation(String userEntered) {
		
		log.info("User has entered: " + userEntered);
		
		log.info("Getting Event collection...");
		MongoCollection<Document> event = db.getCollection("Event");

        log.info("Fetching all records in the Event collection where location contains: " + userEntered);
        // find(regex("field name", "pattern", "options"));
        FindIterable<Document> results = event.find(regex("location", userEntered, "i")); // i for case-insensitive
        MongoCursor<Document> cursor = results.iterator();
        
        try {
            while(cursor.hasNext()) {
            	// print results in Json format
                log.info(cursor.next().toJson());
            }
        } 
        finally {
            cursor.close();
            log.info("End of records where event location contains: " + userEntered);        
        }
	}
	
	/**
	 * Query Event event by what the event name contains
	 * @param userEntered string entered by user
	 */
	public void selectEventByNameEvent(String userEntered) {
		
		log.info("User has entered: " + userEntered);
		log.info("Getting Event collection...");

        log.info("Fetching all records in the Event collection where event name contains: " + userEntered);
        // find(regex("field name", "pattern", "options"));
        FindIterable<Document> results = event.find(regex("name", userEntered, "i")); // i for case-insensitive
        
        MongoCursor<Document> cursor = results.iterator();
        
        try {
            while(cursor.hasNext()) {
            	// print results in Json format
                log.info(cursor.next().toJson());
            }
        }
        finally {
            cursor.close();
            log.info("End of records where event name contains: " + userEntered);
        }     
	}
	
	public static void main(String[] args) {
		Database database = new Database();
		database.connect();
	}
	
}