/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

/**
 *
 * @author 815822
 */
public class UserService {

    public User get(int roleID) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User();        
        return user;
    }
    
    public List<User> getAll(String email) throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll(email);
        return users;
    }
    
    public void insert(String email, String firstName, String lastName, String password, boolean active, int roleID) throws Exception {
        User user = new User(email, firstName, lastName, password, active, roleID);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, String firstName, String lastName, String password, boolean active, int roleID) throws Exception {
        User user = new User(email, firstName, lastName, password, active, roleID);
        UserDB userDB = new UserDB();
        userDB.update(user); 
    }
    
    public void delete(int roleId) throws Exception {
        User user = new User();
        user.setRoleID(roleID);
        UserDB userDB = new UserDB();        
        userDB.delete(user);
    }
    

}
