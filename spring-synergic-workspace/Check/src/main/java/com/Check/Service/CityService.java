package com.Check.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.CityBO;

@Service
public class CityService {

	@Autowired
	CityBO cityBO;
}
