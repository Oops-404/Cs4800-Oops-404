package cs4800.databaseTest;

import static com.mongodb.client.model.Filters.eq; // FILTERS!!!!

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
 * Database testing class
 * 
 */
public class DatabaseTest {
	
	private static final Logger log = Logger.getLogger(DatabaseTest.class.getName());
	
	private static String URI = "mongodb+srv://admin:Oops!404@oops404-ijzpy.azure.mongodb.net/test?retryWrites=true&w=majority";
	private static MongoClient mongoClient = null;
	private static MongoDatabase db = null;
	
	public DatabaseTest() {	
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
	}
	
	/**
	 * Initialize connection to MongoDB server and access Oops404 database
	 * 
	 */
	public void connect() {
		
		try {
			mongoClient = new MongoClient(new MongoClientURI(URI));
			log.info("Connected to MongoDB :)");
			log.info("Accessing Oops404 database");
			db = mongoClient.getDatabase("Oops404");
		} 
		
		catch (MongoException e) {
        	log.log(Level.SEVERE, "Not connected to MongoDB :(", e);
		}
	}
		
	/**
	 * Query test events by their location
	 * @param enterLocation location entered by user
	 */
	public void selectEventByLocationTest(String enterLocation) {
		
		log.info("User has entered: " + enterLocation);
		
		log.info("Getting test collection");
		MongoCollection<Document> test = db.getCollection("test");

        log.info("Fetching all records in the test collection where location is " + enterLocation);
        FindIterable<Document> fi = test.find(eq("location", enterLocation));
        MongoCursor<Document> cursor = fi.iterator();
        
        try {
            while(cursor.hasNext()) {               
                log.info(cursor.next().toJson());
            }
        } finally {
            cursor.close();
            log.info("End of records where location is " + enterLocation);
        }     
	}
	
	/**
	 * Query test data from test collection
	 */
	public void test() {
		
		log.info("Getting test collection");
		MongoCollection<Document> test = db.getCollection("test");
				
        log.info("Fetching all records in the test collection");
        FindIterable<Document> fi = test.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {               
                log.info(cursor.next().toJson());
            }
        } finally {
            cursor.close();
            log.info("End of records");
        }         
        
	}
	
	public static void main(String[] args) {
		DatabaseTest database = new DatabaseTest();
		database.connect();
		
		database.test(); 
		
		database.selectEventByLocationTest("Cal Poly Pomona");
		database.selectEventByLocationTest("home");	
	}
	
}