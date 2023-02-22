package com.bus.service;

import java.util.List;

import com.bus.model.FeedBack;

public interface IFeedBackService {

	
	   FeedBack addFeedBack(FeedBack feedback);
  
	   FeedBack updateFeedBack (FeedBack feedback);

	   FeedBack viewFeedBack(int feedbackld);
 
	   List<FeedBack> viewAllFeedBack();
}
