package com.atguigu.java11;

import org.junit.Test;

import java.io.FileOutputStream;

public class InputStreamTest {
	
	@Test
	public void testStreamTransfer() throws Exception {
		var cl = this.getClass().getClassLoader();
		try (var is = cl.getResourceAsStream("file"); var os = new FileOutputStream("file2")) {
			is.transferTo(os);
		}
	}
}
