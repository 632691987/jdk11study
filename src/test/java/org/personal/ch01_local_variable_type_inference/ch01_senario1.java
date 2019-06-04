package org.personal.ch01_local_variable_type_inference;

import org.junit.Test;

import javax.annotation.Nullable;
import java.util.function.Predicate;

/**
 * 由于 var 的特性是非显式制造变量，在 intellij 下用 ctrl + 鼠标浮动到变量处可以自动帮忙显示出变量具体的类型
 */
public class ch01_senario1 {

	@Test
	public void testCase01() {
		var text = "this is a new type";
		System.out.println(text);

		//text=23 --> 这是错误的，一旦定下来就不能够改变
	}

	@Test
	public void testCase02() {
		var object = new ClassB();

		//object = new ClassA(); --> 首先赋予子类，然后给父类，这也是不可以的。
	}

	@Test
	public void testCase03() {
		var object = new ClassA();

		//这是没有问题的，因为可以后给子类，以前也一样可以如此
		object = new ClassB();
	}

	@Test
	public void testCase04() {
		/**
		 * 下面全部都不允许，原因是一旦设置 var, 就必须要立刻知道 JVM 的具体类型。
		 *
		 * 		var a;
		 * 		var nothing = null;
		 * 		var lambda = () -> System.out.println("Pity!");
		 * 		var method = this::someMethod;
		 */
	}

	@Test
	public void testCase05() {
		Predicate<String> predicate = (@Nullable var aaaaaaaaaaaa) -> true;
	}

}
