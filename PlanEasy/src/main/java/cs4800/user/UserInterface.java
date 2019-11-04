package cs4800.user;

import java.util.Set;
import java.util.UUID;

import cs4800.security.Role;

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
    
    public String getPassword();
    
    public void setPassword(String password);
    
    public boolean isEnabled();
    
    public void setEnabled(boolean enabled);
    
    public void setRoles(Set<Role> roles);
    
    public Set<Role> getRoles();
    
    public void setEmail(String email);
    
    public String getEmail();
}
