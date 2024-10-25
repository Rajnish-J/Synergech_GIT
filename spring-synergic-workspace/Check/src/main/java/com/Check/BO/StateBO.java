package com.Check.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Check.Repo.StateRepo;

@Component
public class StateBO {

	@Autowired
	StateRepo stateRepo;
}
