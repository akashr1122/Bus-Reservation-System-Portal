package com.bus.service;

import java.util.List;

import com.bus.model.FeedBack;

public interface IFeedBackService {

	
	public FeedBack addFeedBack(FeedBack feedback);
  
	 public FeedBack updateFeedBack (FeedBack feedback);

	 public  FeedBack viewFeedBack(int feedbackld);
 
	  public List<FeedBack> viewAllFeedBack();
}
