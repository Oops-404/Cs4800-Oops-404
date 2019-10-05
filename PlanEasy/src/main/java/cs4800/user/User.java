package cs4800.user;

import java.util.UUID;

/*
 * This is an implementation of {@link UserInterface}
 * User class that will hold all of the
 * information of a user
 */
public class User implements UserInterface {
    // Name of the user
    private String name = null;

    // ID of the user
    private UUID userId = null;

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
