package cs4800.database;

import static com.mongodb.client.model.Filters.*; 

import org.bson.Document;
import org.jboss.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/*
 * Database class
 * 
 */
public class Database {
	
	private static final Logger log = Logger.getLogger(Database.class);

	private static String URI = "mongodb+srv://admin:Oops!404@oops404-ijzpy.azure.mongodb.net/test?retryWrites=true&w=majority";
	private static MongoClient mongoClient = null;
	private static MongoDatabase db = null;
	
	public Database() {	}
	
	/**
	 * Initialize connection to MongoDB server and access Oops404 database
	 * 
	 */
	public void connect() {
		
		try {
			mongoClient = new MongoClient(new MongoClientURI(URI));
			log.info("Connected to MongoDB :)");
			db = mongoClient.getDatabase("Oops404");
		} 
		
		catch (MongoException e) {
        	log.error("Not connected to MongoDB :(", e);
		}
	}
	
	/**
	 * Query Events by their location
	 * @param enterLocation location entered by user
	 */
	public void selectEventByLocation(String enterLocation) {
		
		log.info("User has entered: " + enterLocation);
		
		log.info("Getting Events collection");
		MongoCollection<Document> events = db.getCollection("Event");

        log.info("Fetching all records in the test collection where location is " + enterLocation);
        FindIterable<Document> find = events.find(eq("location", enterLocation));
        MongoCursor<Document> cursor = find.iterator();
        
        try {
            while(cursor.hasNext()) {
            	// print in Json format
                log.info(cursor.next().toJson());
            }
        } finally {
            cursor.close();
            log.info("End of records");
        }
	}
	
	public static void main(String[] args) {
		Database database = new Database();
		database.connect();
	}
	
}