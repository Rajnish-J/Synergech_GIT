package com.Check.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Check.Repo.CityRepo;

@Component
public class CityBO {

	@Autowired
	CityRepo cityRepo;
}
