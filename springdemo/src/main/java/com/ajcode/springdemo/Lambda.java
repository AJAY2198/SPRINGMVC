package com.ajcode.springdemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface A{
	 String show(int i);
}

public class Lambda {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = (i)-> "hello79";
			
		
		System.out.println(obj.show(5));
		
		List<Integer> arr = Arrays.asList(13,2,33,4,14);
		
		
		
		
	//	arr.forEach((i)->System.out.println(i));
		
		Stream<Integer> data=arr.stream();
		Function<Integer,Integer> fun = n->n*n;
		
		Integer i1 =data
		.filter(i->i%2==1)
		.sorted()
		.map(n->fun.apply(n))
		.reduce(0,(c,e)->c+e);
		System.out.println(i1);
		
        //System.out.println(arr.stream().collect(Collectors.summingInt((i)->i)));
	
	   
	}

}
