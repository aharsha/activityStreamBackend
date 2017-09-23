package com.stackroute.activitystream.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.User;



@Repository("circleDao")
@Transactional
public class CircleDaoImpl implements CircleDAO {

	
	@Autowired
	SessionFactory sessionFacory;
	@Autowired
	UserDao userDao;
	
	//=======================addCircle===================================
	@Override
	public boolean addCircle(Circle circle) {
		try {
			User owner=userDao.getUserWithId(circle.getOwnerid());
			if(owner!=null)
			{
			circle.setCircleid((int)(Math.random()*100000));
			circle.setCreateddate(new Date());
			sessionFacory.getCurrentSession().save(circle);
			return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	


		
		
	


	

	
	//=======================getCircle==========================================
	@Override
	public Circle getCircle(int circleid)
	{
	
		return (Circle)sessionFacory.getCurrentSession().createQuery("from Circle where circleid =:circleid)").setParameter("circleid",circleid).uniqueResult();
		//return 	(List<Circle>)sessionFacory.getCurrentSession().createNativeQuery("select * from circle where circleId in( select circleId from activity.subscribecircle where userId=:userId)",Circle.class).setParameter("userId",userId).list();
	}
	
	//========================getAllCircles================================================
	@Override
	public List<Circle> getAllCircles() {
		
		List<Circle> allCircles=sessionFacory.getCurrentSession().createQuery("from Circle").list();
		return allCircles;
	}















	//===================deletecircle=================================

	@Override
	public boolean deleteCircle(int circleid) {
		try
		{
		Session session=sessionFacory.getCurrentSession();
		Circle circle = (Circle)session.load(Circle.class,circleid);
		session.delete(circle);

		if (circle != null) {
			return true;
		} else {
			return false;
		}
		}catch(Exception e){return  false;}
	}










//here update is not working ->Hibernate – Non Unique Object Exception
	//so i used merge method
	@Override
	public boolean updateCircle(Circle circle)
	{
		try {

			if (circle != null) {
				
				if((getCircle(circle.getCircleid())!=null))
				{
					circle.setCreateddate(new Date());
					System.out.println("updated circle");
				sessionFacory.getCurrentSession().merge(circle);
				System.out.println("updated circle");
				return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	
	
	}







	
	

	


