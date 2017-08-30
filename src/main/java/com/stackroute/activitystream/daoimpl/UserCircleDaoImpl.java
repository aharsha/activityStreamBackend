package com.stackroute.activitystream.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.UserCircleDao;
import com.stackroute.activitystream.model.SubscribeCircle;


@Repository("userCircleDao")
@Transactional
public class UserCircleDaoImpl  implements UserCircleDao
{

	@Autowired
	SessionFactory sessionFacory;
	
	@Override
	public boolean subscribeToCircle(SubscribeCircle subscribeCircle) {
		
		
		
		
		subscribeCircle.setSubscriberid((int)(Math.random()*100000));
	
		subscribeCircle.setDataofjoin(new Date());
		subscribeCircle.setStatus("A");
		
		try {
			sessionFacory.getCurrentSession().save(subscribeCircle);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	
		
		
		return true;
	}

	@Override
	public boolean unSubscribeCircle(String userEmail, int circleId) {
Query query = sessionFacory.getCurrentSession().createQuery("delete SubscribeCircle where userid=:userId and circleid=:circleId");
		
		query.setParameter("userId",userEmail);
		query.setParameter("circleId",circleId);
		
		
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		   
		return true;
		}
		else
		{
			
			return false;	
		}

	}

	@Override
	public List<SubscribeCircle> myCircles(String userId) {
		return sessionFacory.getCurrentSession().createQuery("from Circle where circleid in(select circleid from SubscribeCircle where userid=:userId)").setParameter("userId",userId).list();
		//return 	(List<Circle>)sessionFacory.getCurrentSession().createNativeQuery("select * from circle where circleId in( select circleId from activity.subscribecircle where userId=:userId)",Circle.class).setParameter("userId",userId).list();

	}

}
