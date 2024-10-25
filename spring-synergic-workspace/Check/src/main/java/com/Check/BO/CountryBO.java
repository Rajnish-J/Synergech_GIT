package com.Check.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Check.Repo.CountryRepo;

@Component
public class CountryBO {

	@Autowired
	CountryRepo countryRepo;
}
