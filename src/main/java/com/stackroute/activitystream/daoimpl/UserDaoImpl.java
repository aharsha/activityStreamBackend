package com.stackroute.activitystream.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFacory;

	
	public boolean addUser(User user) {

		try {
			
			if (user != null) {
				
				
				sessionFacory.getCurrentSession().save(user);
				
			}
			return true;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}

	public boolean updateUser(User user) {

		try {
			
			if (user != null) {
			
				
				sessionFacory.getCurrentSession().saveOrUpdate(user);
				
			
			}
			return true;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}

	public boolean validateUser(String email,String password) {
		try {
		
		Query query=sessionFacory.getCurrentSession().createQuery("From User where email=:email and password=:pwd", User.class);
		User user=(User)query.setParameter("email", email).setParameter("pwd",password).getSingleResult();
		
		if(user!=null)
		{//jhjhkhj
			return true;
		}
		else
			{
			return false;
			}
		
		}
		catch (Exception e) {
			
			System.out.println(e);
			return false;
		}
		
	}

	public boolean deleteUser(String email) {
		Query query=sessionFacory.getCurrentSession().createQuery("delete User where email=:email", User.class);
		User user=(User)query.setParameter("email", email);
		
		
		if(user!=null)
		{
			return true;
		}
		else
			{
			return false;
			}
		
		}
	}

	

