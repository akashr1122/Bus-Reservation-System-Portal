package com.bus.frontEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.model.Bus;
import com.bus.repository.BusDao;
@Service
public class FrontEndServiceImpl implements frontEndService {
	@Autowired
	private BusDao busDao;
	@Override
	public List<Bus> getAllBusByRoute(String from, String to) {
		List<Bus> list=busDao.getAllBusByRoute(from, to);
		return list;
	}

}
