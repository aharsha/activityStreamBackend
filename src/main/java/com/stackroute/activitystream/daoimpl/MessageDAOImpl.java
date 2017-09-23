package com.stackroute.activitystream.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
			sessionFacory.getCurrentSession().save(inbox);
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
				for(String user:userCircleDao.getAllUsers(37756))
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
	public List<Message> inBox(String userId) {
		List<Message> messageList=sessionFacory.getCurrentSession().createQuery("from Message where recieverId=:recieverId").setParameter("recieverId",userId).list();
		
		return messageList;
	}
	
	@Override
	public List<Message> circleInBox(int circleId) {
List<Message> circleMessageList=sessionFacory.getCurrentSession().createQuery("from Message where recieverCircleId=:circleId").setParameter("circleId",circleId).list();
		
		return circleMessageList;
		
	}

}
