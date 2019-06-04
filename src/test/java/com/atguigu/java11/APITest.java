package com.atguigu.java11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;



public class APITest {

	@Test
	public void testStream() {
		//Create stream
		Stream<Integer> stream1 = Stream.of(3,6,9,12,15,18);

		//stream operation
		stream1.forEach(System.out::println);
		Stream.of().forEach(System.out::println);

		//This will throw NullPointerException
		//Stream.of(null).forEach(System.out::println);
		Stream.ofNullable(null).forEach(System.out::println);
		Assert.assertTrue(Stream.ofNullable(null).count()==0);
		Assert.assertTrue(Stream.ofNullable(1000).count()==1);
	}
	
	@Test
	public void testImmutableSet() {
		LocalDate localDate = LocalDate.of(2019, 1, 21);
		localDate.atTime(1,2);
		Set<Integer> set = Set.of(100, 50, 20, 30, 10, 8);// if appear duplicate element, it will throw exception
		System.out.println(set.getClass());
	}
	
	@Test
	public void testImmutableList() {
		int[] arr = {1, 9, 3, 2, 8};
		List<String> list1 = Arrays.asList("aa", "yyy", "zzz", "123");
		List<String> list2 = List.of("aa", "bbb", "cc", "DD");

		//Both below will throw UnsupportedOperationException
		//list1.add("1111");
		//list2.add("1111");
	}
	
	@Test
	public void test1() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bbb");
		list.add("cc");
		list.add("DD");
		
		System.out.println(list);
	}
}
