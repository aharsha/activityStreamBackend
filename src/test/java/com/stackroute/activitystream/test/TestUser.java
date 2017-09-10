package com.stackroute.activitystream.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Hibernate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;

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
	
	//adding user ->new user
	@Test
	
	public void addUser_SuccessTestCase()
	{
		user=new User();
		
		user.setUsername("ramesh");
		user.setEmail("ramesh@gmail.com");
		user.setMobile("9652983089");
		user.setPassword("ramESH@1234");
		
		
		assertEquals("success",true,userDao.addUser(user));
		
	}
	
@Test
	
	public void updateUser_PositiveTestCase()
	{
		user=new User();
		
		user.setUsername("ramesh");
		user.setEmail("ramesh@gmail.com");
		user.setMobile("9652983099");
		user.setPassword("ramESH@1234");
		
		
		assertEquals("success",true,userDao.updateUser(user));
		
	}
	
@Test(expected=HibernateOptimisticLockingFailureException.class)

public void updateUser_NegativeTestCase()
{
	user=new User();
	
	user.setUsername("ramesh");
	user.setEmail("xyz@gmail.com");
	user.setMobile("9652983099");
	user.setPassword("ramESH@1234");
	
	
	assertEquals("update Failure",false,userDao.updateUser(user));
	
}
	@Test(expected=DataIntegrityViolationException.class)
	public void addUser_FailTestCase() 
	{

		 User user=new User();
		user.setEmail("baba@gmail.com");
		user.setMobile("9652983089");
user.setPassword("babaBABA@1234");

user.setUsername("baba");

assertEquals("success",false,userDao.addUser(user));
	}
	




@Test(expected=ConstraintViolationException.class)

public void passwordPattern_FailTestCase()
{
	user=new User();
	
	user.setUsername("harsha");
	user.setEmail("harsha@gmail.com");
	user.setMobile("9652983089");
	user.setPassword("harsha@1234");
	
	
	assertEquals("UserName pattern not matching",false,userDao.addUser(user));
	
}

@Test
	public void deleteUser_PositiveTestCase() 
	{
		assertEquals("success",true,userDao.deleteUser("raju@gmail.com"));

	}

@Test
public void deleteUser_NegativeTestCase() 
{
	assertEquals("not deleted",false,userDao.deleteUser("raju@gmail.com"));

}

@Test

public void validUser_PositiveTestCase()
{
	
	
	assertEquals("Login Credentials are correct",true,userDao.validateUser("harsha@gmail.com", "harSHA@12345"));
	
}

@Test

public void ValidUser_NegativeTestCase()
{
	
	
	assertNotEquals("Login Credentials are not correct",true,userDao.validateUser("harsha@gmail.com", "harSHA@12345678"));
	
}

@Test
public void getUserWithId_PositiveTestCase() 
{

	 
User user= userDao.getUserWithId("harsha@gmail.com");

assertEquals("success","harsha@gmail.com",user.getEmail());
			
		
}

@Test(expected=NullPointerException.class)
public void getUserWithId_NegativeTestCase() 
{

	 
User user= userDao.getUserWithId("xyz@gmail.com");

assertNotEquals("success","xyz@gmail.com",user.getEmail());
			
		
}

@Test
public void getAllUsersTestCase() 
{

	 
List<User> users= userDao.getAllUsers();

		for (User user : users)
		{
			System.out.println("user name  = "+user.getEmail());
		}
}

}
