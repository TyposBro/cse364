package me.typosbro.moshimoshi;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoshiMoshiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testHelloWorld() {
		assertTrue(true);
		System.out.println("Hello World");
	}

}
