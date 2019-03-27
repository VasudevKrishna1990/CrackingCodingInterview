package _002_LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Remove_Dups {

	public static void main(String[] args) {
		List list = new List(1);
		list.next = new List(2);
		list.next.next = new List(5);
		list.next.next.next = new List(2);
		list.next.next.next.next = new List(5);
		list.next.next.next.next.next = new List(7);
		list.next.next.next.next.next.next = new List(2);
		list.next.next.next.next.next.next.next = new List(5);
		printList(list);
		//remove_dups_N2_approach(list);/*Using 2 pointers*/
		//remove_dups_NLogN_approach(list);/*Using Sort */
		remove_dups_N_approach(list);/*Using Hashing*/
	//	printList(list);
	}

	private static void remove_dups_N_approach(List list) {
		ArrayList<Integer>theList = new ArrayList<>();
		HashSet<Integer>theSet = new HashSet<>();
		while(list!=null)
		{
			theList.add(list.value);
			list=list.next;
		}
		
		for(int i=0;i<theList.size();i++)
		{
			if(theSet.contains(theList.get(i)))
			{
				theList.remove(i);
			}
			else {
				theSet.add(theList.get(i));
			}
		}
		
		System.out.println(theSet);
	}

	private static void remove_dups_NLogN_approach(List list) {
		ArrayList<Integer>theList = new ArrayList<>();
		while(list!=null)
		{
			theList.add(list.value);
			list=list.next;
		}
		Collections.sort(theList);
		ArrayList<Integer> prev = theList;
		ArrayList<Integer> ptr1 = theList;
		for(int i=0;i<theList.size()-1;)
		{
			if(theList.get(i) == theList.get(i+1))
			{
				theList.remove(i+1);
			}
			else
			{
				i++;
			}
		}
		
		System.out.println(theList);
	}

	private static void remove_dups_N2_approach(List list) {
		
		List ptr1 = list;
		List ptr2 = ptr1.next;
		List prev = null;
		for(ptr1 = list;ptr1!= null;ptr1= ptr1.next)
		{
			prev = null;
			for(ptr2= ptr1.next;ptr2!= null;ptr2 = ptr2.next)
			{
				if(prev == null)
					prev = ptr1;
				
				if(ptr1.value == ptr2.value)
					remove_node(ptr2,prev);
				else
					prev =ptr2;
			}
		}
		
	}

	private static void remove_node(List ptr2,List prev) {
		if(ptr2.next !=  null)
			prev.next = ptr2.next;
		else
			prev.next = null;
	}

	public static void printList(List list) 
	{
		List start = list;
		while(start!= null)
		{
			System.out.print(start.value +" ->");
			start = start.next;
		}
		System.out.println("End");
	}
}

class List
{
	int value;
	List next;
	
	public List(int value)
	{
		this.value = value;
		this.next = null;
	}
}