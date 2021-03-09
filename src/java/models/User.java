
package models;

import java.io.Serializable;

/**
 *
 * @author 807930
 */
public class User implements Serializable {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean active;
    private int roleID;
    
    public User() {
        
    }
    
    public User(String email, String firstName, String lastName, String password, boolean active, int roleID){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
        this.roleID = roleID;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean isActive(){
        return active;
    }
    
    public void setActive(boolean Active) {
        this.active = active;
    }
    
    public int getRoleID() {
        return roleID;
    }
    
    public void setRoleID() {
        this.roleID = roleID;
    }
}
