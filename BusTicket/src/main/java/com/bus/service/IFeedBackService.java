package com.bus.service;

import java.util.List;

import com.bus.exception.FeedBackNotFoundException;
import com.bus.model.FeedBack;

public interface IFeedBackService {

	
	   FeedBack addFeedBack(FeedBack feedback) ;
  
	   FeedBack updateFeedBack (FeedBack feedback) throws FeedBackNotFoundException;

	   FeedBack viewFeedBack(int feedbackld) throws FeedBackNotFoundException;
 
	   List<FeedBack> viewAllFeedBack() throws FeedBackNotFoundException;
}
