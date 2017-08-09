package com.stackroute.activitystream.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.Message;

public class TestCircle {
	private static AnnotationConfigApplicationContext context;
	private static CircleDAO circleDao;
	
	private static MessageDAO messageDao;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
	circleDao=(CircleDAO)context.getBean("circleDao");
	messageDao=(MessageDAO)context.getBean("messageDao");
	}
	
//@Test
	
	public void addCircleTestCase()
	{
		Circle circle=new Circle();
		
		circle.setCircleId((int)(Math.random()*100000));
		circle.setCircleDiscription("bootCamp_Training");
		circle.setCircleName("VegGroup");
		circle.setCreatedDate(new Date());
		circle.setOwnerId("gowtham@gmail.com");
		circle.setStatus("active");
		assertEquals("success",true,circleDao.addCircle(circle));
		
	}



//@Test

public void addUserToCircleTestCase()
{
	
	assertEquals("success",true,circleDao.addUser("sofia@gmail.com",40159));
	
}
//@Test
public void deleteCircleTestCase()
{
	
	
	assertEquals("deleting circle",true,circleDao.deleteCircle(1));
	
}
@Test
public void myCirclesTestCase()
{
	//assertEquals("Mycircles are", actual);
	List<Circle> circles=circleDao.myCircle("sofia@gmail.com");
	
	for(Circle circle:circles)
	{
		System.out.println(" circleName = "+circle.getCircleName());
		for(Message msg:messageDao.circleInBox(circle.getCircleId()))
		{
			System.out.print("From "+msg.getSenderId());
			System.out.print(" message:  "+msg.getMessageContent());
			
			//System.out.print(" To "+msg.getRecieverId());
			System.out.println(" at "+msg.getMessageTime());
			
		}
	}
}
	
}
