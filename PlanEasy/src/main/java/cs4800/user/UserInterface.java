package cs4800.user;

import java.util.UUID;

public interface UserInterface {
    /*
     * Get the name of user
     *
     * @return user name
     */
    public String getName();

    /*
     * Get UUID of user
     *
     * @return UUID
     */
    public UUID getUserId();

    /*
     * Set the name of user
     *
     * @param name of user
     */
    public void setName(String name);

    /*
     * Set the ID of the user
     *
     * @param ID of user
     */
    public void setUserId(UUID userId);
}
