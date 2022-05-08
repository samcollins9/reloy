/*
 * Created on Jan 8, 2005
 *
 */
package com.reloy.dao.impl;
import java.util.List;

import com.reloy.model.User;
import com.reloy.util.HibernateUtil;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.reloy.dao.UserDAO;
/**
 * @author Samuel
 */
public class HibernateUserDAO implements UserDAO{

	public User getUser(String userName){
  		try{
  		    // open session
  		  		Session session = HibernateUtil.currentSession();
  		 		
  	  			String query = "from User user where user.username=:uname";
  		    	List list = session.createQuery(query)
				.setParameter("uname", userName, Hibernate.STRING)
				.list();

  		  		session.close();  		 
  		  		if (list.size() > 0)
  		  		return (User) list.get(0);
  		  		
  	  		}catch (Exception e){
  	  			e.printStackTrace();
  	  		}finally{
  	        	try{
  	        		
  	        		HibernateUtil.closeSession();
  	        	}catch(Exception e){
  	        		e.printStackTrace();
  	        	}
  	        }
		return null;
	}
	
	public void saveUser(User user){
  		try{
  		    // open session
  		  		Session session = HibernateUtil.currentSession();
  		 		Transaction tx= session.beginTransaction();
  		 		
				session.save(user);
				
  		  		tx.commit();
  		  		session.close();
	  	}catch (Exception e){
  	  		e.printStackTrace();
  		}finally{
  	        try{
  	       		HibernateUtil.closeSession();
  	       	}catch(Exception e){
  	       		e.printStackTrace();
  	       	}
  		}		
	}

	/* (non-Javadoc)
	 * @see sam.home.dao.UserDAO#getAllUsers()
	 */
	public List getAllUsers() {
  		try{
  		    // open session
  		  		Session session = HibernateUtil.currentSession();
  		 		
  	  			Session sess = HibernateUtil.currentSession();
  	  			String query = "from User user";
  		    	List list = sess.createQuery(query).list();

  		  		session.close();  		    	
  		  		return list;
  	  		}catch (Exception e){
  	  			e.printStackTrace();
  	  		}finally{
  	        	try{
  	        		HibernateUtil.closeSession();
  	        	}catch(Exception e){
  	        		e.printStackTrace();
  	        	}
  	        }
		return null;
	}
}
