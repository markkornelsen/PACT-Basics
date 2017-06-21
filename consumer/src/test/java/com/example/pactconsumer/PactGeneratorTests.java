package com.example.pactconsumer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class PactGeneratorTests {

	@Rule
	public PactProviderRule rule = new PactProviderRule("pact-provider", this);

	@Pact(provider = "pact-provider", consumer = "pact-consumer")
	public PactFragment createPact(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");

		return builder.uponReceiving("Provider Example Request")
				.path("/Songs").method("POST").willRespondWith()
				.headers(headers).status(200)
				.body(PactDslJsonArray.arrayEachLike()
						.stringType("title")
						.closeObject())
				.toFragment();
	}

	@Test
	@PactVerification("pact-provider")
	public void runTest() {

		String url = rule.getConfig().url();

		ParameterizedTypeReference<List<PactConsumerSong>> responseType = 
				new ParameterizedTypeReference<List<PactConsumerSong>>() {};
		List<PactConsumerSong> songs = new RestTemplate().exchange(
				url + "/Songs", 
				HttpMethod.POST, null, 
				responseType)
				.getBody();

		// assertEquals(new
		// PactConsumerClient(rule.getConfig().url()).consumerSongs(),
		// Arrays.asList(new PactConsumerSong("Prologue (If I Ever Lose My Faith
		// in You)", 2)));

		// assertEquals(new
		// PactConsumerClient(rule.getConfig().url()).consumerSongs(),
		// Arrays.asList(new PactConsumerSong("Prologue (If I Ever Lose My Faith
		// in You)", 1),
		// new PactConsumerSong("Fields of Gold", 2),
		// new PactConsumerSong("One", 3),
		// new PactConsumerSong("Mysterious Ways", 4)
		// ));

	}
}