package com.atguigu.java11;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class OptionalTest {
	
	@Test
	public void testOptionalAPI() throws Exception {
		Optional<String> optional = Optional.ofNullable(null);
		String object = optional.orElse("abc");
		Assert.assertTrue(object.equals("abc"));

		Optional<String> object2 = optional.or(() -> Optional.of("vincent"));
		Assert.assertTrue(object2.get().equals("vincent"));
	}
}
