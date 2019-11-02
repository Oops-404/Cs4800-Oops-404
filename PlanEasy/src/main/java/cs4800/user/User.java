package cs4800.user;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

/*
 * This is an implementation of {@link UserInterface}
 * User class that will hold all of the
 * information of a user
 */
@Getter
@Setter
@Document (collection = "user")
public class User implements UserInterface {

    // ID of the user
    @Id
    @Field(value = "userId")
    private UUID userId = null;
    
    // Name of the user
	@Field(value = "name")
    private String name = null;
	
    /*
     * Constructor so that each new user must have a name and
     * a randomly generated user ID
     */
    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUserId() {
        return userId;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
