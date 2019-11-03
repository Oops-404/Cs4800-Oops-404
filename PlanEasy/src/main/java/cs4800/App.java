package cs4800;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cs4800.dao.EventDAO;
import cs4800.dao.UserDAO;
import cs4800.event.Event;
import cs4800.user.User;

@EnableMongoRepositories({"cs4800.dao"})
@SpringBootApplication
public class App extends SpringBootServletInitializer implements CommandLineRunner {

	private static final Logger log = Logger.getLogger(App.class.getName());

	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
    /**
     * This is the running main method for the web application.
     * Please note that Spring requires that there is one and
     * ONLY one main method in your whole program. You can create
     * other main methods for testing or debugging purposes, but
     * you cannot put extra main method when building your project.
     */
    public static void main(String[] args) throws Exception {
        // Run Spring Boot
        SpringApplication.run(App.class, args);
    }
    
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
	
	/*
	 * Add some sample data into test collection
	 * ALSO sample of how to format input date and time parameters.
	 */
	@Override
	public void run(String... args) throws Exception {
		log.info("---TESTING---");
//		userDAO.deleteAll();
//		userDAO.save(new User("test", bCryptPasswordEncoder.encode("pass")));
		
//		eventDAO.save(new Event("Pumpkin Patch", "10/5/2019", "10/31/2019", "Cal Poly Pomona", "Halloween"));
//		eventDAO.save(new Event("Pumpkin Carving", "10/31/2019", "10/31/2019", "5:00 PM", "8:00 PM", "Cal Poly Pomona", "Halloween"));
//		eventDAO.save(new Event("Self-Care Happy Hour", "11/5/2019", "11/5/2019", "2:00 PM", "4:00 PM", "Cal Poly Pomona"));
//		eventDAO.save(new Event("Console Tournaments", "11/7/2019", "11/7/2019", "6:00 PM", "8:00 PM", "Cal Poly Pomona", "fun"));
//		eventDAO.save(new Event("Spring Career Fair", "3/5/2020", "3/5/2020", "10:30 AM", "2:30 PM", "Cal Poly Pomona", "career"));
	}
    
}

