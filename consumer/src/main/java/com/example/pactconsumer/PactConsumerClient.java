package com.example.pactconsumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class PactConsumerClient {
	private String url;
	private RestTemplate restTemplate;

	@Autowired
	public PactConsumerClient(@Value("${serviceUrl}") String url) {
		this.url = url;
		this.restTemplate = new RestTemplate();
	}

	public List<PactConsumerSong> consumerSongs() {

		ParameterizedTypeReference<List<PactConsumerSong>> responseType = new ParameterizedTypeReference<List<PactConsumerSong>>() {};
		List<PactConsumerSong> songs = restTemplate.exchange(url + "/Songs", HttpMethod.GET, null, responseType).getBody();
		return songs;
	}
}