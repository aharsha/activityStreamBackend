package com.stackroute.activitystream.daoimpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.User;



@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	User user;

	public Session getSessionFactory() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}
//=====================================================
	public boolean addUser(User user) {

		try {

			if (user != null) {

				getSessionFactory().save(user);

			}
			return true;
		} catch (Exception e) {

			return false;
		}
	}
//=====================================================
	public boolean updateUser(User user) {

		try {

			if (user != null) {

				sessionFactory.getCurrentSession().update(user);

			}
			return true;
		} catch (Exception e) {

			return false;
		}
	}
//=======================================================
	public boolean validateUser(String email, String password) {
		try {
			System.out.println("at validat=================");
			Query query = sessionFactory.getCurrentSession()
					.createQuery("From User where email=:email and password=:pwd");
			 query.setParameter("email", email).setParameter("pwd", password);
			 user=(User)query.uniqueResult();

System.out.println(user);
System.out.println("at validat=================");
			if (user != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
e.printStackTrace();
			return false;
		}

	}
//==========================deleteUser==============================
	public boolean deleteUser(String email) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class,email);
		System.out.println(user+"at delee==============");
		session.delete(user);

		if (user != null) {
			return true;
		} else {
			return false;
		}
		}catch(Exception e){return  false;}

	}
//===========================getAllUsers=================================
	
	public List<User> getAllUsers() {

	
	return sessionFactory.getCurrentSession().createQuery("from User").list();

		

	}
//===========================getUserWithEmail================================
	
	public User getUserWithId(String emailId) {
		//user = (User) sessionFactory.getCurrentSession().load(User.class, emailId);
		user = (User)sessionFactory.getCurrentSession().createQuery("from User where email =:emailId)").setParameter("emailId",emailId).uniqueResult();
		
		System.out.println(emailId+"at dao");
		System.out.println(user+"user");
		return user;
	}
}
