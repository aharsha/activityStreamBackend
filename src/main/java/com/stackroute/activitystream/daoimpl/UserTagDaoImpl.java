package com.stackroute.activitystream.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.dao.UserTagDao;
import com.stackroute.activitystream.model.UserTag;

@Repository("userTagDao")
@Transactional
public class UserTagDaoImpl  implements UserTagDao
{
	
	@Autowired
	SessionFactory sessionFacory;
	
	@Autowired
	UserTag userTag;

	@Override
	public List<String> getAllTags(String userID) {
		return sessionFacory.getCurrentSession().createQuery("select tag from Message").list();
	}

	@Override
	public boolean subscribeUserToTag(String userID, String tag) {
		
		userTag.setId((int)(Math.random()*100000));
		userTag.setTag(tag);
		userTag.setUserID(userID);
		
		try {
			sessionFacory.getCurrentSession().save(userTag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
		
	
		return true;

	}

	@Override
	public boolean unSubscribeUserFromTag(String userID, String tag) {
		UserTag userTag=myTagByTag(userID, tag);
		try {
			sessionFacory.getCurrentSession().delete(userTag);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

	@Override
	public List<String> myTags(String userID) {
		// TODO Auto-generated method stub
		return sessionFacory.getCurrentSession().createQuery("select tag from UserTag where userID= ?")
				.setString(0, userID)
				.list();
	}

	@Override
	public UserTag myTagByTag(String userID, String tag)
	{
		return (UserTag) sessionFacory.getCurrentSession().createQuery("from UserTag where userID= ? and tag= ?")
				.setString(0, userID)
				.setString(1, tag)
				.uniqueResult();
	}

}
