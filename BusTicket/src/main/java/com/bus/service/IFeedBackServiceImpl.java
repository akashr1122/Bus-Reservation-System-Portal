package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.FeedBackNotFoundException;
import com.bus.model.FeedBack;
import com.bus.repository.FeedbackDao;

@Service
public class IFeedBackServiceImpl implements IFeedBackService {

	@Autowired
	private FeedbackDao feedbackDao;

	@Override
	public FeedBack addFeedBack(FeedBack feedback) {

		FeedBack fBack = feedbackDao.save(feedback);
		return fBack;
	}

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedBackNotFoundException {

		feedbackDao.findById(feedback.getFeedBackId())
				.orElseThrow(() -> new FeedBackNotFoundException("Give feedback first..❤️"));
		FeedBack fBack = feedbackDao.save(feedback);

		return fBack;

	}

	@Override
	public FeedBack viewFeedBack(int feedbackld) throws FeedBackNotFoundException {

		FeedBack fBack = feedbackDao.findById(feedbackld)
				.orElseThrow(() -> new FeedBackNotFoundException("feedback not found which id is " + feedbackld));
	
		  return fBack;
	}
	

	@Override
	public List<FeedBack> viewAllFeedBack() throws FeedBackNotFoundException {
		
		 List<FeedBack> feedBacks = feedbackDao.findAll();
		    
		 if(feedBacks.isEmpty()) throw new FeedBackNotFoundException("No Any feedback present..");
	         
		      return feedBacks;
	}

}
