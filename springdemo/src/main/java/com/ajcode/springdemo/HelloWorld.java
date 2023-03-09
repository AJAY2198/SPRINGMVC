package com.ajcode.springdemo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Employee{
    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}
class Parent{}
class Child extends Parent{}

interface A1{
	  short f1();
	}
	interface B{
	  short f1();
	}

	class Test implements A1, B{

		@Override
		public short f1() {
			// TODO Auto-generated method stub
			return 0;
		}   
	  

	  
	  
	}   


class HelloWorld {
    public static void main(String[] args) {
        
        
//        Employee e = new Employee();
//        Consumer<Employee> setname = t->t.setName("Play JAva");
//        setname.accept(e);
//        System.out.println(e.getName());
//        Function<Integer, String> getInt =t ->t*10  +" data mutliplied";
//        
//        System.out.println(getInt.apply(23));
//        
//        Supplier<Double> getRandom = ()->Math.random();
//        
//        System.out.println(getRandom.get());
        Test c = new Test();
        		c.f1();
        		
        		
       Thread t = new Thread() {
    	   public void run() {
    		   System.out.print("Ajay");
    	   }
    	   
    	   
       };
       t.start();
       String a =new String();
       String b ="";
       System.out.println(a.equals(b));
    }
    
    
    
     
     
}