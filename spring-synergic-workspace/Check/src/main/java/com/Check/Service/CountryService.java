package com.Check.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.CountryBO;

@Service
public class CountryService {
	@Autowired
	CountryBO countryBO;
}
