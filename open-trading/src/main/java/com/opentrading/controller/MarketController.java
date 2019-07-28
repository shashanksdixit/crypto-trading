package com.opentrading.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.opentrading.entity.AssetsResponse;

@RestController
public class MarketController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.server}")
	private String url;
	
	@GetMapping("assets")
	public ResponseEntity<AssetsResponse> getAssets() throws IOException, URISyntaxException {
		URI uri = new URI(url + "/assets");
		ResponseEntity<AssetsResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, AssetsResponse.class);
		AssetsResponse response = responseEntity.getBody();
		System.out.println(response);
		return responseEntity;
	}
}
