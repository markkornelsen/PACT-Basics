package com.example.pactconsumer;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class PactGeneratorTests {
	
	@Rule
	public PactProviderRule rule= new PactProviderRule("pact-provider", this);

	@Pact(provider = "pact-provider", consumer = "pact-consumer")
	public PactFragment createPact(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        sb.append("{");
        sb.append("\"title\":\"Prologue (If I Ever Lose My Faith in You)\",");
        sb.append("\"number\":1");
        sb.append("},");
        sb.append("{");
        sb.append("\"title\":\"Fields of Gold\",");
        sb.append("\"number\":2");
        sb.append("},");
        sb.append("{");
        sb.append("\"title\":\"One\",");
        sb.append("\"number\":3");
        sb.append("},");
        sb.append("{");
        sb.append("\"title\":\"Mysterious Ways\",");
        sb.append("\"number\":4");
        sb.append("}");
        sb.append("]");
        
		return builder.uponReceiving("Provider Example Request")
				.path("/Songs")
				.method("GET")
				.willRespondWith()
				.headers(headers)
				.status(200)
				.body(sb.toString()).toFragment();
	}

	@Test
	@PactVerification("pact-provider")
	public void runTest() {
		assertEquals(new PactConsumerClient(rule.getConfig().url()).consumerSongs(),
				Arrays.asList(new PactConsumerSong("Prologue (If I Ever Lose My Faith in You)", 1), 
						new PactConsumerSong("Fields of Gold", 2),
						new PactConsumerSong("One", 3),
						new PactConsumerSong("Mysterious Ways", 4)
						));
	}
}