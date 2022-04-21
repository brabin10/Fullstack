package com.java;

import java.util.ArrayList;
import java.util.Iterator;

class Student{
	int roll;
	String name;
}

public class ArrayListDemo {

	public static void main(String[] args) {
		
		//list1 can only store String Objects
		ArrayList<String> list1 = new ArrayList<String>(); //type specific
		
		//list2 can store any type of Objects
		ArrayList list2 = new ArrayList();        //any type
		
		
		Student s1 = new Student();
		s1.roll = 101;
		s1.name = "Mike";
		
		// 1. Add Data in List
		list1.add("John");    //0
		list1.add("Jennie");  //1
		list1.add("Jim");     //2
		list1.add("Jack");    //3
		list1.add("John");    //4
		list1.add("Joe");     //5
		//list1.add(10);   //error 
		//list1.add(2.2);  //error
		
		
		list2.add("John");
		list2.add(10);
		list2.add(2.2);
		list2.add('A');
		list2.add(s1);
		
		//Print reference to list -> shall print elements in the list the way we added in a sequence
		System.out.println("list 1 is: " + list1);
		System.out.println("list 2 is: " + list2);
		
		//2. Get the element from list
		String name = list1.get(2);
		System.out.println("name is: " +name);
		
	    Object o = list2.get(2);
		System.out.println("O is: "+o);
		
		//3. Update Element in List
		list1.set(2, "Fionna");
		System.out.println("list1 now is: " +list1);
		
		//4. Remove Element from List
		list1.remove(2);
		System.out.println("list1 after remove is: " +list1);
		
		//list.clear(); ->Remove All
		
		if(list1.contains("John")) {
			System.out.println("John is in the list");
			
			//5. Iterate in ArrayList
			
			System.out.println("===Iterating with Basic For Loop===");
			for(int i=0; i<list1.size(); i++) {
				System.out.println(list1.get(i));
			}
			
			
			System.out.println("===Iterating with Enhanced For Loop===");
			for(String str : list1) {
				System.out.println(str);
			}
			System.out.println("==============");
			
			System.out.println("===Iterating with Iterator===");
			Iterator<String> itr = list1.iterator();
			/*System.out.println(itr.next());
			System.out.println(itr.next());
			System.out.println(itr.next())*/
			
			while(itr.hasNext()) {
				String str = itr.next();
				System.out.println(str);
				if(str.equals("Jack")) {
					itr.remove();
				}
			}
			System.out.println("==========");
			
			System.out.println("list1 after iteration is: " +list1);
		}

	}

}
