package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Circle;

public interface CircleDAO {

 boolean addCircle(Circle circle);

	boolean deleteCircle(int circleid);
	boolean updateCircle(Circle circle);

	 List<Circle> getAllCircles();

	 Circle getCircle(int circleid);
	 
	 int getCircleId(String circleName);
	
	

}
