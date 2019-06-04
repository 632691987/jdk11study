package com.atguigu.java11;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {
	
	@Test
	public void testName3() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/java/com/atguigu/java11/StringTest.java");
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		String string = new String(buffer);
		string.lines().forEach(System.out::println);
	}
	
	@Test
	public void testLineCount() throws Exception {
		String string = "mvn\n123\nfff";
		Assert.assertTrue(string.lines().count()==3);
	}

	@Test
	public void testStringBlankRelated() throws Exception {
		String string = " \t  \r\n ";
		Assert.assertTrue(string.isBlank()==true);
		
		string = " \t  \r\n abc \tav";
		//strip able to delete non-English space character!
		String string2 = string.strip();
		Assert.assertTrue(string2.equals("abc \tav"));

		String string4 = string.stripLeading();
		Assert.assertTrue(string4.equals("abc \tav"));

		String string5 = string.stripTrailing();
		Assert.assertTrue(string5.equals(" \t  \n abc \tav"));
	}
}	
