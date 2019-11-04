package cs4800.user;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import cs4800.security.Role;
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
	
	// Users encrypted password
	@Field(value = "password")
	private String password = null;
	
	// Users email
	@Field(value = "email")
	private String email;

	// If the account is active
	@Field(value = "enabled")
	private boolean enabled = true;
	
	@DBRef
	private Set<Role> roles;

	
    /*
     * Constructor so that each new user must have a name and
     * a randomly generated user ID
     */
    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID();
    }
    
    public User() {
    	this.userId = UUID.randomUUID();
    }
    
    public User(String name, String password) {
    	this.name = name;
    	this.password = password;
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
    
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Set<Role> getRoles() {
		return roles;
	}

	@Override
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
}
