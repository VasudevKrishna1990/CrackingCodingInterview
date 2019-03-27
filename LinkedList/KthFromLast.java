package _002_LinkedList;

import java.util.ArrayList;

/* Return Kth to Last: 
 * Implement an algorithm to find the kth to last element of a singly linked list. */
public class KthFromLast extends Remove_Dups{

	public static void main(String[] args) {
		int k =5;
		Remove_Dups rmvDups = new Remove_Dups();
		/*ArrayList<Integer>theList = new ArrayList<>();
		theList.add(1);theList.add(2);theList.add(5);
		theList.add(10);theList.add(15);theList.add(16);theList.add(17);theList.add(21);theList.add(23);theList.add(25);
		System.out.println(theList);
		System.out.println("---- ***** -----------");
		System.out.println(kthFromLast(theList,k)); */
		List root = new List(1);
		root.next = new List(5);
		root.next.next = new List(10);
		root.next.next.next = new List(15);
		root.next.next.next.next = new List(11);
		root.next.next.next.next.next = new List(21);
		root.next.next.next.next.next.next = new List(31);
		root.next.next.next.next.next.next.next = new List(41);
		root.next.next.next.next.next.next.next.next = new List(2);
		root.next.next.next.next.next.next.next.next.next = new List(25);
		root.next.next.next.next.next.next.next.next.next.next = new List(71);
		rmvDups.printList(root);
		System.out.println(k+ "th Element from last is "+kthElementFromLast(root,k));
	}

	private static int kthElementFromLast(List root,int k)
	{
		List ptr = root;
		while(k > 0)
		{
			ptr = ptr.next;
			k--;
		}
	
		List ptr1 = root; 
		while(ptr != null)
		{
			ptr=ptr.next;
			ptr1=ptr1.next;
		}
		
		return ptr1.value;
	}

	private static int kthFromLast(ArrayList<Integer> theList,int k) {  /*Using Collection framework*/
		return theList.get(theList.size()-k);
	}
}
/*
class List
{
	int value;
	List next;
	
	public List(int value)
	{
		this.value = value;
		this.next = null;
	}
}*/