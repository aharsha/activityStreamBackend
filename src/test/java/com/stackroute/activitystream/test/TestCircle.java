package com.stackroute.activitystream.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;

public class TestCircle {
	private static AnnotationConfigApplicationContext context;
	private static CircleDAO circleDao;
	private static Circle circle;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
	circleDao=(CircleDAO)context.getBean("circleDao");
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



@Test

public void addUserToCircleTestCase()
{
	
	assertEquals("success",true,circleDao.addUser("abbas@gmail.com",40159));
	
}
//@Test
public void deleteCircleTestCase()
{
	
	
	assertEquals("deleting circle",true,circleDao.deleteCircle(1));
	
}
	
}
