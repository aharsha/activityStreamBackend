package com.stackroute.activitystream.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.dao.UserCircleDao;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.model.User;
import com.stackroute.activitystream.model.UserInBox;
import com.stackroute.activitystream.model.UserOutBox;




@Repository("messageDao")
@Transactional
public class MessageDAOImpl implements MessageDAO
{

	@Autowired
	private SessionFactory sessionFacory;
	
	@Autowired
	private UserCircleDao userCircleDao;
	
	@Override
	public boolean sendMessage(UserOutBox message) {
		try {
			message.setId((int)(Math.random()*100000));
			message.setMessageTime(new Date());
			System.out.println("============"+message.getMessageContent());
			UserInBox inbox=new UserInBox();
			inbox.setMessageContent(message.getMessageContent());
			inbox.setMessageType(message.getMessageType());
			inbox.setRecieverCircleId(message.getRecieverCircleId());
			inbox.setRecieverId(message.getRecieverId());
			inbox.setSenderId(message.getSenderId());
			inbox.setTag(message.getTag());
			sessionFacory.getCurrentSession().save(message);
		//	sessionFacory.getCurrentSession().save(inbox);
			System.out.println(message.getMessageContent());
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
				
	}
		@Override
		public boolean sendMessageToCircle(UserOutBox message) {
			try {
				System.out.println("before try");
				for(String user:userCircleDao.getAllUsers(message.getRecieverCircleId()))
				{
				
				
					UserInBox inbox=new UserInBox();
			//message.setId((int)(Math.random()*100000));
					int y=(int)(Math.random()*100000);
					System.out.println(y+"====");
								
					inbox.setId(y);
					inbox.setMessageTime(new Date());
					inbox.setMessageContent(message.getMessageContent());
					inbox.setMessageType(message.getMessageType());
					inbox.setRecieverCircleId(message.getRecieverCircleId());
					inbox.setRecieverId(user);
					inbox.setSenderId(message.getSenderId());
					inbox.setTag(message.getTag());
					Session session=sessionFacory.getCurrentSession();
					session.save(inbox);
					System.out.println(message.getMessageContent());
					session.flush();
					session.clear();
					
				}
				int x=(int)(Math.random()*100000);
				System.out.println(x+"====");
				message.setId(x);
				message.setMessageTime(new Date());
				System.out.println("============"+message.getMessageContent());
				sessionFacory.getCurrentSession().save(message);
				
						
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
		
		
	}
	@Override
	public List<UserOutBox> inBox(String friend,String user) {
		List<UserOutBox> messageList;
		//messageList=sessionFacory.getCurrentSession().createQuery("from UserOutBox where (recieverId=:rId and senderId=:sId) or (senderId=:rId and recieverId=:sId)  .setParameter("rId",friend).list();
		
		Criteria messageCriteria=sessionFacory.getCurrentSession().createCriteria(UserOutBox.class);
		// 
		ArrayList<String> al=new ArrayList<String>(); 
		al.add(friend);
		al.add(user);
		
		Criterion sendList=Restrictions.in("senderId",al);
		Criterion recieveList=Restrictions.in("recieverId",al);
		
		
		LogicalExpression friendMsg=Restrictions.and(sendList, recieveList);
	
		
		messageCriteria.add(friendMsg);
	
		messageCriteria.addOrder(Order.asc("messageTime"));
		return messageCriteria.list();
	}
	
	@Override
	public List<UserOutBox> circleInBox(int circleId) {
		
		Criteria messageCriteria=sessionFacory.getCurrentSession().createCriteria(UserOutBox.class);
		
		Criterion circleMesseagesCrieterian=Restrictions.eq("recieverCircleId",circleId);
		
//List<UserOutBox> circleMessageList=sessionFacory.getCurrentSession().createQuery("from UserOutBox where  recieverCircleId=:circleId").setParameter("circleId",circleId).list();
		messageCriteria.add(circleMesseagesCrieterian);
		messageCriteria.addOrder(Order.asc("messageTime"));
		
		return messageCriteria.list();
	
	}

}
