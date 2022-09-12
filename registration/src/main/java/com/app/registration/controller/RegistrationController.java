package com.app.registration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.entity.Registration;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired 
	private RegistrationService service;
	@PostMapping("/registrationDetails")
	@CrossOrigin(origins="http://localhost:4200")
	public Registration registrationDetails(@RequestBody Registration details)throws Exception{
		String tempFirstName=details.getFirstName();
		if(tempFirstName!=null &&!"".equals(tempFirstName)) {
			Registration regobj=service.fetchDetailsByFirstName(tempFirstName);
			if(regobj !=null) {
			throw new Exception("FirstName with"+tempFirstName+" is already exists");
			
		}
	}
		Registration regobj=null;
		regobj=service.saveDetails(details);
		return regobj;
 
	}
	@GetMapping("getregistrationdetails")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Registration> fetchRegistrationlist(){
		List<Registration> regDetails=new ArrayList<>();
		regDetails=service.fetchRegistrationList();
		return regDetails;
		}
	
	@PostMapping("/addregistrationdetails")
	public Registration  saveDetails(@RequestBody Registration registration) {
		return service.saveDetailstoDB(registration);
	}
	
	@DeleteMapping("/deleteregistrationdetailsbyid/{id}")
	public String DeletedetailsbyId(@PathVariable int id) {
		return service.deleteDetailsById(id);
	}
	/**@PutMapping("/updateregistrationdetailsbyId/{id}")
	public Registration fetchDetalsById(@RequestBody Registration registration,@PathVariable int id)
	{
		return service.fetchDetailsById(id).get();
	}**/
	@PutMapping("/updateregistrationdetailsbyId/{id}")
	public Registration updateDetails(
		    @PathVariable(value = "id") Integer id,
		     @RequestBody Registration registrationDetails)  {
		Registration details = service.findById(id);
		details.setFirstName(registrationDetails.getFirstName());
		details.setLastName(registrationDetails.getLastName());
		details.setCity(registrationDetails.getCity());
		details.setStreet(registrationDetails.getStreet());
		details.setZip(registrationDetails.getZip());
		details.setEmail(registrationDetails.getEmail());
		
		return service.saveDetailstoDB(details);
		
	}
}