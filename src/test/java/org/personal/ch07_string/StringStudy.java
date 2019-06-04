package org.personal.ch07_string;

import org.junit.Test;

public class StringStudy {

	@Test
	public void testCase1() {
		System.out.println(" 12345  ".strip().length());//不要两边
		System.out.println(" 12345  ".stripLeading().length());//不要最头
		System.out.println(" 12345  ".stripTrailing().length());//不要最尾
		System.out.println(" 12345  ".repeat(2));//不要最尾
		System.out.println("".isBlank());//不要最尾
		System.out.println("123\n456\n789".lines().findFirst().get());//不要最尾

	}

}
