package com.app.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.entity.Registration;
import com.app.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;

	public Registration fetchDetailsByFirstName(String name) {
		// TODO Auto-generated method stub
		return repo.findByFirstName(name);
	}

	public Registration saveDetails(Registration details) {
		
		return repo.save(details);
	}

	public List<Registration> fetchRegistrationList() {
		
		return repo.findAll();
	}

	public Registration saveDetailstoDB(Registration registration) {
		
		return repo.save(registration);
	}

	public String deleteDetailsById(int id) {
		String result;
		try {
			repo.deleteById(id);
			result="Registration Details are successfully deleted";
		}catch (Exception e) {
			result="Details not deleted";
		}
		return result;
	}

	public List<Registration> fetchDetailsById(int id) {
		
		return repo.findAll();
	}

	public Registration findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	//public Optional<Registration> fetchDetailsById(int id) {
		// TODO Auto-generated method stub
		//return repo.findById(id);
	//}
	

}
