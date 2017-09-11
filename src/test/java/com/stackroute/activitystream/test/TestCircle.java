package com.stackroute.activitystream.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.User;

public class TestCircle {
	private static AnnotationConfigApplicationContext context;
	private static CircleDAO circleDao;

	private static MessageDAO messageDao;

	private static Circle circle;
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
		circleDao = (CircleDAO) context.getBean("circleDao");
		messageDao = (MessageDAO) context.getBean("messageDao");
	}

	//@Test

	public void addCircleTestCase() {
		Circle circle = new Circle();

		circle.setCirclename("Veg-NonVeg");

		circle.setCirclediscription("Veg-NonVeg Both");

		circle.setOwnerid("harsha@gmail.com");

		assertEquals("success", true, circleDao.addCircle(circle));

	}

	@Test

	public void updateCircle_PositveTestCase()
	{
		circle=new Circle();
		
		circle.setCirclename("Veg-NonVeg  day base");

		circle.setCirclediscription("Veg-NonVeg some times veg");

		circle.setOwnerid("harsha@gmail.com");

		circle.setCircleid(60799);
		
		
		assertEquals("update Success",true,circleDao.updateCircle(circle));
		
	}
	
	
	//@Test
	public void deleteCircle_PositiveTestCase() {
		assertEquals("circle deleted  successfully", true, circleDao.deleteCircle(2342));

	}

	@Test
	public void deleteCircle_NegativeTestCase() {
		assertEquals("circle not deleted", false, circleDao.deleteCircle(23421));

	}
	
	
	

	@Test
	public void myCirclesTestCase() {
		// assertEquals("Mycircles are", actual);
		List<Circle> circles = circleDao.getAllCircles();

		for (Circle circle : circles) {
			System.out.println(" circleName = " + circle.getCirclename());
			System.out.println(" circleDiscription = " + circle.getCirclediscription());
			/*
			 * for(Message msg:messageDao.circleInBox(circle.getCircleid())) {
			 * System.out.print("From "+msg.getSenderId()); System.out.print(
			 * " message:  "+msg.getMessageContent());
			 * 
			 * //System.out.print(" To "+msg.getRecieverId());
			 * System.out.println(" at "+msg.getMessageTime());
			 * 
			 * }
			 */

		}
	}

}
