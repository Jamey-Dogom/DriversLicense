package com.jd.relationships.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jd.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

	Optional<License> findByPersonId(Long id);

}
