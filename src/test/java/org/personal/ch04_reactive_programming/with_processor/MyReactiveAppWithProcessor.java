package org.personal.ch04_reactive_programming.with_processor;

import org.personal.ch04_reactive_programming.EmpHelper;
import org.personal.ch04_reactive_programming.entity.Employee;
import org.personal.ch04_reactive_programming.entity.Freelancer;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveAppWithProcessor {

	/**
	 * 1，其实就是一个 SubmissionPublisher<Employee></> 去 subscribe 一个 SubmissionPublisher<Freelancer>，
	 *    只是后者同时是一个 Processor，作用是把 Employee转换成Freelancer
	 *
	 * 2，同时后者对应一个 MyFreelancerSubscriber(implements Subscriber<Freelancer>) 用于处理最终的Freelancer
	 *
	 * 3，在消费时，最开始是消费 Employee (emps.stream().forEach(i -> publisher.submit(i));)
	 */

	public static void main(String[] args) throws InterruptedException {
		// Create End Publisher
		SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

		// Create Processor
		MyProcessor transformProcessor = new MyProcessor(s -> new Freelancer(s.getId(), s.getId() + 100, s.getName()));

		//Create End Subscriber
		MyFreelancerSubscriber subs = new MyFreelancerSubscriber();

		//Create chain of publisher, processor and subscriber
		publisher.subscribe(transformProcessor); // publisher to processor
		transformProcessor.subscribe(subs); // processor to subscriber

		List<Employee> emps = EmpHelper.getEmps();

		// Publish items
		System.out.println("Publishing Items to Subscriber");
		emps.stream().forEach(i -> publisher.submit(i));

		// Logic to wait for messages processing to finish
		while (emps.size() != subs.getCounter()) {
			Thread.sleep(10);
		}

		// Closing publishers
		publisher.close();
		transformProcessor.close();

		System.out.println("Exiting the app");
	}

}