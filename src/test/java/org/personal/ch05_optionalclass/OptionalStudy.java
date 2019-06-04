package org.personal.ch05_optionalclass;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalStudy {

	@Test
	public void forJava8BasicSample() {
		System.out.println(Optional.of(2));
		System.out.println(Optional.empty());
	}

	@Test
	public void forJava9Improvements() {
		Stream<Optional<Entity>> optionalStream = Stream.of(
				Optional.of(new Entity("AA1","BB1")),
				Optional.of(new Entity("AA2","BB2")),
				Optional.of(new Entity("AA3","BB3")),
				Optional.of(new Entity("AA4","BB4")),
				Optional.empty(),
				Optional.ofNullable(null),
				Optional.of(new Entity("AA6","BB6"))
		);

		Stream<Entity> stream2 = optionalStream.flatMap(op -> op.stream());
		List<String> entities = stream2.map(en -> en.getName()).collect(Collectors.toList());
		System.out.println(entities);


		//注意，flatMap 本身是做 stream 的哦
		List<Entity> entities1 = Lists.newArrayList(new Entity("AA1","BB1"));
		Stream<Entity> entityStream = entities1.stream().flatMap(entity-> Stream.of(entity));
	}

	@Test
	public void testJava8NormalAPI() {
		Optional<Integer> opt1 = Optional.of(2);
		opt1.ifPresent( x -> System.out.println("Option1: Result found = " + x));

		Optional<Integer> opt2 = Optional.empty();
		opt2.ifPresent( x -> System.out.println("Option2: Result found: " + x));

		System.out.println("Option2: Result not found, default vlaue = " + opt2.orElse(new Integer(0)));

		if(opt2.isPresent())
			System.out.println("Option2: Result found.");
		else
			System.out.println("Option2: Result not found.");
	}

	@Test
	public void testJava9ifPresentOrElse() {
		Optional<Integer> opt1 = Optional.ofNullable(null);
		opt1.ifPresentOrElse( x -> System.out.println("Result found: " + x), () -> System.out.println("Not Found."));
	}

	/**
	 * 实现了锁链式的
	 */
	@Test
	public void testJava9OptionalOr() {
		Optional<String> opStr1 = Optional.of("Rams1");
		Optional<String> opStr2 = Optional.of("Rams2");
		Optional<String> opStr3 = Optional.of("Rams3");

		String result = opStr1.or(() -> opStr2).or(()-> opStr3).orElse("Default");
		System.out.println(result);
	}

	public class Entity {
		public Entity(String name, String value) {
			this.name = name;
			this.value = value;
		}

		private String name;
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

}
