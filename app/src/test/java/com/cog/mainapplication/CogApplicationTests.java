package com.cog.mainapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class CogApplicationTests {

	// No constructors needed unless explicitly required, and it should be default
	public CogApplicationTests() {
		// Optional: Initialize resources if needed
	}

	@Test
	public void contextLoads() {
		// Your test logic here
	}

}
