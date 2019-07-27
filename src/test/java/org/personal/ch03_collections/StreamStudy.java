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
		/**
		 * discard when pridicate satisify, once satisfy, go to the end
		 */
		List<Integer> list = Stream.of(1,2,3,4,2,1,8).dropWhile(n -> n < 3).collect(Collectors.toList());  // [3, 4, 2, 1, 8]
		System.out.println(list);
	}

	/**
	 * 这个 takeWhile() 方法使用一个断言作为参数，返回给定 Stream 的子集直到断言语句第一次返回 false。如果第一个值不满足断言条件，将返回一个空的 Stream。
	 */
	@Test
	public void testCase03() {
		/**
		 * Get everything when prodicte satisify, once not, stop
		 */
		List<Integer> list = Stream.of(1,2,3,4,2,1).takeWhile(n -> n < 3).collect(Collectors.toList());  // [1, 2]
		System.out.println(list);
	}

}
