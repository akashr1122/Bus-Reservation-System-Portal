package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bus.model.FeedBack;
import com.bus.service.IFeedBackService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
public class FeedBackController {

	@Autowired
	private IFeedBackService feedBackService;

	@PostMapping("/bus/feedback")
	public ResponseEntity<FeedBack> addFeedBackHandler( @Valid @RequestBody FeedBack feedBack) {

		FeedBack fBack = feedBackService.addFeedBack(feedBack);

		return new ResponseEntity<FeedBack>(fBack, HttpStatus.CREATED);

	}

	@PutMapping("/bus/feedback")
	public ResponseEntity<FeedBack> updateFeedBackHandler( @Valid @RequestBody FeedBack feedBack) {

		FeedBack fBack = feedBackService.updateFeedBack(feedBack);

		return new ResponseEntity<FeedBack>(fBack, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bus/feedback/{fId}")
	public ResponseEntity<FeedBack> getFeedBackByIdHandler( @Valid @PathVariable Integer fId) {

		FeedBack fBack = feedBackService.viewFeedBack(fId);

		return new ResponseEntity<FeedBack>(fBack, HttpStatus.ACCEPTED);

	}

	@GetMapping("/bus/feedbacks")
	public ResponseEntity<List<FeedBack>> getAllFeedBackHandler() {

		List<FeedBack> fBack = feedBackService.viewAllFeedBack();

		return new ResponseEntity<List<FeedBack>>(fBack, HttpStatus.OK);

	}

}
