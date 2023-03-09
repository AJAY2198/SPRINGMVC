package com.ajcode.springdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiTrhreadingClass {

	public static void main(String[] args) {
		
		final int[] i = {1};
//		Runnable newNumber = new Runnable() {
//
//			@Override
//			public void run() {
//				while(i[0]<10) {
//					System.out.println(Thread.currentThread().getName()+" : "+(i[0]));
//					i[0]++;
//				}
//				
//			}
//			
//			
//		};
//		Runnable newNumber = new Runnable() {
//
//			@Override
//			public void run() {
//				for(int i =1; i<=10 ; i++) {
//					System.out.println(Thread.currentThread().getName()+" : "+(i));
//					i++;
//				}
//				
//			}
//			
//			
//		};
		final AtomicInteger counter = new AtomicInteger(1);
		Runnable newNumber = new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					
					synchronized(counter) {
						int i = counter.getAndIncrement();
						if(i>100) {
							break;
						}
						System.out.println(Thread.currentThread().getName()+" : "+(i));
						counter.notifyAll();
						
						try {
							counter.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					
					
				}
				
			}
			
			
		};
		Thread t1 = new Thread(newNumber);
		Thread t2 = new Thread(newNumber);
		t1.start();
		t2.start();
		
	}

}
