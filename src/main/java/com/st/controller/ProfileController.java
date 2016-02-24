package com.st.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.domain.salesforce.Profile;
import com.st.repository.ProfileRepository;

@RestController
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;

	@RequestMapping(value = "/api/profiles", method = RequestMethod.GET)
	public List<Profile> findAllProfiles() {
		return profileRepository.findAll();
	}
}
