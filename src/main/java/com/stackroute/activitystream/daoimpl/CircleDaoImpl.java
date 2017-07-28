package com.stackroute.activitystream.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.SubscribeCircle;
import com.stackroute.activitystream.model.User;

@Repository("circleDao")
@Transactional
public class CircleDaoImpl implements CircleDAO {

	
	@Autowired
	SessionFactory sessionFacory;
	
	@Override
	public boolean addCircle(Circle circle) {
		try {
			sessionFacory.getCurrentSession().save(circle);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(String userId, int circleId) {

		SubscribeCircle subscribeCircle=new SubscribeCircle();
		subscribeCircle.setSubscriberId((int)(Math.random()*100000));
		subscribeCircle.setCircleId(circleId);
		subscribeCircle.setUserId(userId);
		
		try {
			sessionFacory.getCurrentSession().save(subscribeCircle);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	
		
		
		return true;
	}

	@Override
	public boolean removeUser(String userID, String circleID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Circle circle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCircle(int circleId) {
		Query query = sessionFacory.getCurrentSession().createQuery("delete Circle where circleId=:circleId");
		query.setParameter("circleId",circleId);
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		    System.out.println("Circle Removed successfully");
		return true;
		}
		else
		{
			System.out.println("Circle Can not be removed");
			return false;	
		}
		
	}
	
	
	

}
