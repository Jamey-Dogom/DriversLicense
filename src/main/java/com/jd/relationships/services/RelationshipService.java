package com.jd.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.relationships.models.License;
import com.jd.relationships.models.Person;
import com.jd.relationships.repositories.LicenseRepository;
import com.jd.relationships.repositories.PersonRepository;

@Service
public class RelationshipService {

	@Autowired
	private PersonRepository perRepo;

	@Autowired
	private LicenseRepository licRepo;

	public Person create(Person p) {
		return perRepo.save(p);
	}

	public License create(License l) {
		return licRepo.save(l);
	}

	public List<Person> allPersons() {
		return perRepo.findAll();
	}

	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = perRepo.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}

	public License findLicense(Long id) {
		Optional<License> optionalLicense = licRepo.findByPersonId(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}

	}
}
