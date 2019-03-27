package _002_LinkedList;

import java.util.HashSet;

/*Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input: A -) B -) C -) 0 -) E - ) C[thesameCasearlierl
Output: C
Hints: #50, #69, #83, #90*/
public class Loop_Detection {
/* A->B->C->D->E->C */
public static void main(String[] args) {
	Node list = new Node('A');
	list.next = new Node('B');
	Node ptr  = new Node('C');
	list.next.next =  ptr;
	list.next.next.next = new Node('D');
	list.next.next.next.next = new Node('E');
	list.next.next.next.next.next = new Node('F');
	list.next.next.next.next.next.next = new Node('G');
	list.next.next.next.next.next.next.next = new Node('H');
	list.next.next.next.next.next.next.next.next = new Node('I');
	list.next.next.next.next.next.next.next.next.next = new Node('J');
	list.next.next.next.next.next.next.next.next.next.next = new Node('K');
	list.next.next.next.next.next.next.next.next.next.next.next = new Node('L');
	list.next.next.next.next.next.next.next.next.next.next.next.next = ptr;
	System.out.println("The loop is detected at Node " );
	System.out.println(detectLoopUsingTwoLoopsAndRemoveLoop(list));
	System.out.println("List after removing loop node");
	list.printNode(list);
	System.out.println(detectLoopUsingHashing(list));
	System.out.println(detectLoopUsingVisitedNode(list));
}

private static char detectLoopUsingVisitedNode(Node list) {
	char ch = '$';
	Node ptr = list;
	while(ptr != null)
	{
		if(ptr.isVisited() == false)
		{
			ptr.visited = 1;
		}
		else
		{
			ch = ptr.ch;
			break;
		}
		ptr = ptr.next;
	}
	
	return ch;
}

private static char detectLoopUsingHashing(Node list) {
	char ch = '$';
	Node ptr = list;
	HashSet<Character> theHashSet = new HashSet<>();
	while(ptr!=null)
	{
		if(theHashSet.contains(ptr.ch))
		{
			ch = ptr.ch;
			break;
		}
		else {
			theHashSet.add(ptr.ch);
		}
		ptr = ptr.next;
	}
	return ch;
}

private static char detectLoopUsingTwoLoopsAndRemoveLoop(Node list) {
	Node slowPtr = list;
	Node fastPtr = list;
	boolean flag = false;
	Node ptr2 = null;
	int count =0;
	while(slowPtr!=null && fastPtr.next!=null && fastPtr!=null)
	{
		slowPtr = slowPtr.next;
		fastPtr = fastPtr.next.next;
		
		if(slowPtr == fastPtr && flag == false)
		{
			flag = true;
			ptr2 = slowPtr;
			count =0;
		}
		else if(slowPtr == fastPtr && flag == true)
		{
			break;
		}
		if(flag == true)
		{
			count++;
		}
	}
	
	slowPtr = list;
	while(count-->0)
	{
		slowPtr = slowPtr.next;		
	}
	
	fastPtr = list;
	
	while(fastPtr !=slowPtr)
	{
		fastPtr = fastPtr.next;
		slowPtr = slowPtr.next;
	}

	slowPtr = slowPtr.next;
	
	while(slowPtr.next != fastPtr)
	{
		slowPtr = slowPtr.next;
	}
	slowPtr.next = null;
	return fastPtr.ch;
}
	
}
