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
		
	
		circle.setCirclename("Veg-NonVeg");
		
	
		circle.setCirclediscription("Veg-NonVeg Both");
		
		
		
		
		
		circle.setOwnerid("harsha@gmail.com");
		
		assertEquals("success",true,circleDao.addCircle(circle));

		
	}



//@Test

public void addUserToCircleTestCase()
{
	
	
	
}
//@Test
public void deleteCircleTestCase()
{
	
	
	
	
}
@Test
public void myCirclesTestCase()
{
	//assertEquals("Mycircles are", actual);
	List<Circle> circles=circleDao.getAllCircles();
	
	for(Circle circle:circles)
	{
		System.out.println(" circleName = "+circle.getCirclename());
		/*for(Message msg:messageDao.circleInBox(circle.getCircleid()))
		{
			System.out.print("From "+msg.getSenderId());
			System.out.print(" message:  "+msg.getMessageContent());
			
			//System.out.print(" To "+msg.getRecieverId());
			System.out.println(" at "+msg.getMessageTime());
			
		}
		*/
		System.out.println(" circleDiscription = "+circle.getCirclediscription());
	}
}
	
}
