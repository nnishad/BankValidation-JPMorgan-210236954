package com.nikhilnishad.bankservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nikhilnishad.bankservice.model.Request;
import com.nikhilnishad.bankservice.model.Response;
import com.nikhilnishad.bankservice.model.Response.Result;

@Service
public class ValidateService {

	@Autowired
	RestTemplate restTemplate;

	@Value("#{${sources}}")
	private Map<String, String> availableSources;

	public Response validateAccountNumber(Request request) {
		Response newResponse = new Response();
		List<Result> responseFromDataSource = new ArrayList<>();
		Map<String, String> requestedSources = new HashMap<>();
		if (request.getSources().size() > 0) {
			for (String source : request.getSources()) {
				requestedSources.put(source, availableSources.get(source));
			}
		} else {
			requestedSources = availableSources;
		}

		for (Map.Entry<String, String> source : requestedSources.entrySet()) {
			Result r = restTemplate.postForObject(source.getValue(), request, Result.class);
			r.setSource(source.getKey());
			responseFromDataSource.add(r);

		}
		newResponse.setResult(responseFromDataSource);
		return newResponse;
	}

}
