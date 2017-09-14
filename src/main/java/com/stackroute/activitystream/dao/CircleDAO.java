package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Circle;

public interface CircleDAO {

 boolean addCircle(Circle circle);

	boolean deleteCircle(int circleid);
	boolean updateCircle(Circle circle);

	 List<Circle> getAllCircles();

	 Circle getCircle(int circleid);
	
	boolean checkCircle(int circleid);
	
	//Why two methods getCircle and checkCircle.  
	//If the getCircle return null  => Circle does not exist
	// else circle exist
	//So no need to write separate methoc lick checkCircle

}
