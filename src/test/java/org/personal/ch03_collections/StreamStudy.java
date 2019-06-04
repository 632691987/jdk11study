package org.personal.ch03_collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy {

	@Test
	public void testCase01() {
		Assert.assertTrue(Stream.ofNullable(null).count()==0);
	}

	@Test
	public void testCase02() {
		List<Integer> list = Stream.of(10,2,1,7,8,3,0).dropWhile(n -> n < 3).collect(Collectors.toList());  // [3, 2, 1]
		System.out.println(list);
	}

	/**
	 * 这个 takeWhile() 方法使用一个断言作为参数，返回给定 Stream 的子集直到断言语句第一次返回 false。如果第一个值不满足断言条件，将返回一个空的 Stream。
	 */
	@Test
	public void testCase03() {
		List<Integer> list = Stream.of(10,2,1,7,8,3,0).takeWhile(n -> n < 3).collect(Collectors.toList());  // [3, 2, 1]
		System.out.println(list);
	}

}
