package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.Circle;

public interface CircleDAO {

	public boolean addCircle(Circle circle);

	public boolean updateUser(Circle circle);

	public List<Circle> getAllCircles();

	public Circle getCircle(int circleid);

}
