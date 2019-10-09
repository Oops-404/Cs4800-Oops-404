package cs4800.database;

import com.mongodb.MongoException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/*
 * Test the connection to the MongoDB database server
 * 
 */
public class DatabaseConnectionTest {

	public static void main(String[] args) {
				
		// connection string URI
		String URI = "mongodb+srv://admin:Oops!404@oops404-ijzpy.azure.mongodb.net/test?retryWrites=true&w=majority";
		MongoClient mongo = null;
		
        try {
        	mongo = new MongoClient(new MongoClientURI(URI));
 
            System.out.println("Connected to MongoDB :)");
            
        } catch (MongoException e) {
        	System.out.println("Not connected to MongoDB :(");
            e.printStackTrace();
        } finally {
            if (mongo!=null) {
            	mongo.close();
            }
        }
	}
}