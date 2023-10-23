package com.example.springcachingbug;

import org.springframework.cache.annotation.Cacheable;

@org.springframework.stereotype.Service
public class Service {

	@Cacheable(cacheManager = "exampleCacheManager", cacheNames = {"exampleData"})
	public ExampleData getData() {
		return new ExampleData("key");
	}

}
