package com.stackroute.activitystream.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;




@Repository("messageDao")
@Transactional
public class MessageDAOImpl implements MessageDAO
{

	@Autowired
	SessionFactory sessionFacory;
	@Override
	public boolean sendMessage(Message message) {
		try {
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
