package org.personal.ch04_reactive_programming.with_processor;

import org.personal.ch04_reactive_programming.entity.Freelancer;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MyFreelancerSubscriber implements Subscriber<Freelancer> {

	private Subscription subscription;

	private int counter = 0;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("MyFreelancerSubscriber::onSubscribe start");
		this.subscription = subscription;
		this.subscription.request(1); //requesting data from publisher
		System.out.println("MyFreelancerSubscriber::onSubscribe end");
	}

	@Override
	public void onNext(Freelancer item) {
		System.out.println("MyFreelancerSubscriber::onNext start");
		counter++;
		this.subscription.request(1);
		System.out.println("MyFreelancerSubscriber::onNext end");
	}

	@Override
	public void onError(Throwable e) {
		System.out.println("Some error happened in MyFreelancerSubscriber");
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("All Processing Done for MyFreelancerSubscriber");
	}

	public int getCounter() {
		return counter;
	}

}