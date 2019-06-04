package org.personal.ch03_collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectionStudy {

	@Test
	public void testCase01() {
		var list = List.of("A", "B", "C");
		var copy = List.copyOf(list);
		System.out.println(list == copy);   // true
	}

	/**
	 * Because list is already immutable there's no practical need to actually create a copy of the list-instance,
	 * therefore list and copy are the same instance.
	 * However if you copy a mutable list,
	 * copy is indeed a new instance so it's guaranteed there's no side-effects when mutating the original list:
	 */
	@Test
	public void testCase02() {
		var list = new ArrayList<String>();
		var copy = List.copyOf(list);
		System.out.println(list == copy);   // false
	}

	//一旦用 of 就是 immutable
	@Test(expected = UnsupportedOperationException.class)
	public void testCase03() {
		var map = Map.of("A", 1, "B", 2);
		map.put("C",3);
	}
}
