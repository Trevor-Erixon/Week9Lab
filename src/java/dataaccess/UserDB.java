/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.User;

/**
 *
 * @author 841898
 */
public class UserDB {
    public List<User> getAll(User user) throws Exception {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try 
        {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        }
        finally 
        {
            em.close();
        }

    }
    
    public User get(String email)  throws Exception {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try 
        {
            User user = em.find(User.class, email);            
            return user;
        } 
        finally 
        {
            em.close();
        }
        
        
    }
    
    public void insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (email, active, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.isActive());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRoleID());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET first_name=?, last_name=?, password=?, active=?, role=? WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            System.out.println("user: "+user);
            System.out.println("user id: " + user.getRoleID());
        
//            System.out.println("user: "+user.getFirstName() + ", "+ );
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPassword());
            ps.setBoolean(4, user.isActive());
            ps.setInt(5, user.getRoleID());
//            ps.setString(5, user.getEmail());
            ps.setString(6, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
