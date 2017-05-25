package com.example.pactconsumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PactConsumerController {
	private final String providerUrl = "http://localhost:8005";

	@RequestMapping(value = "/Albums", method = RequestMethod.GET)
	public PactConsumerAlbum[] providerAlbums() {

		return new RestTemplate().getForObject(providerUrl + "/Albums", PactConsumerAlbum[].class);
	}

	@RequestMapping(value = "/Song", method = RequestMethod.GET)
	public PactConsumerSong consumerSong() {

		return new RestTemplate().getForObject(providerUrl + "/Song", PactConsumerSong.class);
	}
}
