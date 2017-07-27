package com.stackroute.activitystream.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.validation.ConstraintViolationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.User;


public class TestUser {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private static User user;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
	userDao=(UserDao)context.getBean("userDao");
	}
	
	@Test
	
	public void addUserTestCase()
	{
		user=new User();
		
		user.setUserName("harsha");
		user.setEmail("harsha@gmail.com");
		user.setMobile("9652983089");
		user.setPassword("harSHA@1234");
		
		
		assertEquals("success",true,userDao.addUser(user));
		
	}
	

//@Test(expected=DataIntegrityViolationException.class)

public void addUserWithDuplicateEmailTestCase()
{
	
	
	
	assertEquals("UserName pattern not matching",false,userDao.addUser(user));
	
}	


//@Test(expected=ConstraintViolationException.class)

public void passwordPatternTestCase()
{
	
	
	
	assertEquals("UserName pattern not matching",false,userDao.addUser(user));
	
}


//@Test

public void validUserTestCase()
{
	
	
	assertEquals("Login Credentials are correct",true,userDao.validateUser("harsha@gmail.com", "harSHA@1234"));
	
}

//@Test(expected=NullPointerException.class)

public void notValidUserTestCase()
{
	
	
	assertNotEquals("Login Credentials not correct","harshad@gmail.com",userDao.validateUser("harsha@gmail.com", "harSHA@12345"));
	
}


}
