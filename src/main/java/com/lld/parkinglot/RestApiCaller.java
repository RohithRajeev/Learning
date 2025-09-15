package com.lld.parkinglot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestApiCaller {

	private static final int MAX_RETRIES = 3;
	private final RestTemplate restTemplate = new RestTemplate();

	public String callApiWithRetry(String url) throws Exception {
		int attempts = 0;

		while (attempts < MAX_RETRIES) {
			attempts++;
			try {
				System.out.println("Attempt " + attempts + " to call API...");

				ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

				if (response.getStatusCode().is2xxSuccessful()) {
					return response.getBody();
				} else {
					System.out.println("API responded with status: " + response.getStatusCode());
				}

			} catch (Exception e) {
				System.out.println("Error calling API: " + e.getMessage());
			}

			if (attempts < MAX_RETRIES) {
				Thread.sleep(5000); // wait before retry
			}
		}

		throw new Exception("Failed to fetch API data after " + MAX_RETRIES + " attempts.");
	}

	public static void main(String[] args) {
		RestApiCaller caller = new RestApiCaller();
		try {
			String data = caller.callApiWithRetry("https://jsonplaceholder.typicode.com/posts/1");
			System.out.println("API Response: " + data);
		} catch (Exception e) {
			System.err.println("Final Failure: " + e.getMessage());
		}
	}
}
