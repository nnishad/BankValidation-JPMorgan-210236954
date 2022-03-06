package com.nikhilnishad.bankservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nikhilnishad.bankservice.model.Request;
import com.nikhilnishad.bankservice.model.Response;
import com.nikhilnishad.bankservice.services.ValidateService;

@RestController
public class Controller {

	@Value("#{${sources}}")
	private Map<String, String> sources;
	
	@Autowired
	ValidateService validateService;
	@GetMapping("/")
	public Map getSource() {
		return sources;
	}
	
	@PostMapping("/validate")
	public Response validateAccount(@RequestBody Request request) {
		return validateService.validateAccountNumber(request);
	}
}
