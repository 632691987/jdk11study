package org.personal.ch04_reactive_programming.with_processor;

import org.personal.ch04_reactive_programming.entity.Employee;
import org.personal.ch04_reactive_programming.entity.Freelancer;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<Freelancer> implements Processor<Employee, Freelancer> {

	private Subscription subscription;
	private Function<Employee,Freelancer> function;

	public MyProcessor(Function<Employee,Freelancer> function) {
		super();
		this.function = function;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(Employee emp) {
		submit(function.apply(emp));
		subscription.request(1);
	}

	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Done");
	}

}