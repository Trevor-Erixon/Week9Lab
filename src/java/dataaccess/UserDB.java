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
import javax.persistence.EntityTransaction;
import models.Role;
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
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try 
        {
            Role role = user.getRole();
            role.getUserList().add(user);
            trans.begin();
            em.persist(user);
            em.merge(role);
            trans.commit();
        } 
        catch (Exception e)
        {
            trans.rollback();
        }
        finally 
        {
            em.close();
        }
    }

    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try 
        {
            Role role = user.getRole();
            role.getUserList().add(user);
            System.out.println(user);
            trans.begin();
            em.merge(user);
            trans.commit();
        } 
        catch (Exception e)
        {
            trans.rollback();
        }
        finally 
        {
            em.close();
        }
    }

    public void delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try 
        {
            Role role = user.getRole();
            role.getUserList().remove(user);
            trans.begin();
            em.remove(em.merge(user));
            em.merge(role);
            trans.commit();
        } 
        catch (Exception e)
        {
            trans.rollback();
        }
        finally 
        {
            em.close();
        }
    }
}
