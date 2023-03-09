package com.ajcode.springdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {


		
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		
		Stream<Integer> str= arr.stream()
				.peek(i->System.out.println(i))
				.filter(n->n%2==0)
				.peek(i->System.out.println(i))
				.map(n->(n*n))
				.peek(i->System.out.println(i));
		       
		str.forEach(System.out::println);

	}

}
