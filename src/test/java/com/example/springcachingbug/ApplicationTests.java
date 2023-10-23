package com.example.springcachingbug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private Service service;

	@Test
	void contextLoads() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			executorService.submit(() -> {
				try {
					this.service.getData();
				} catch (Exception e) {
					// Handle exception
				}
			});
		}
		assertEquals(this.service.getData(), this.service.getData());
	}

}
