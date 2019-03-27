package _002_LinkedList;
/*
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
*/
public class Intersection {

	public static void main(String[] args) {
		
		Node list1 = new Node('a');
		list1.next = new Node('@');
		list1.next.next = new Node('#');
		list1.next.next.next = new Node('%');
		list1.next.next.next.next = new Node('+');
		list1.next.next.next.next.next = new Node('=');
		list1.next.next.next.next.next.next = new Node('(');
		list1.next.next.next.next.next.next.next = new Node(')');
		list1.next.next.next.next.next.next.next.next = new Node('!');
		list1.next.next.next.next.next.next.next.next.next = new Node('R');
		list1.next.next.next.next.next.next.next.next.next.next = new Node('T');
		list1.next.next.next.next.next.next.next.next.next.next.next = new Node('W');
		list1.next.next.next.next.next.next.next.next.next.next.next.next = new Node('b');
		
		Node ptr = new Node('c');
		list1.next.next.next.next.next.next.next.next.next.next.next.next.next =ptr; 
		Node list2 = new Node('1');
		list2.next = new Node('2');
		list2.next.next = ptr;
		list2.next.next.next = new Node('4');;
		list2.next.next.next.next = new Node('5');;
		
		//list1.printNode(list1);
		//list2.printNode(list2);
		
		Node res = intersectingNode(list1,list2);

		System.out.println("The lists intersecting @ node "+res.ch +" at address "+ res);
		
	}

	private static Node intersectingNode(Node list1, Node list2) {
		Node ptr1 = list1;
		Node ptr2 = list2;
		Node demo = new Node('a');
		int len1 = 0;
		int len2 = 0;
		while(ptr1!=null)
		{
			ptr1 = ptr1.next; 
			++len1;
		}
		
		while(ptr2!=null)
		{
			ptr2 = ptr2.next; 
			++len2;
		}
		
		if(len1>len2)
		{
			list1 = incrementPtr(list1,len1-len2);
		}
		else if(len1<len2){
			list2 = incrementPtr(list2,len2-len1);
		}
		
		while(list1!=null && list2!=null)
		{
			if(list1 == list2) {
				demo.ch = list1.ch;
				break;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		
		return demo;
	}

	private static Node incrementPtr(Node ptr1, int i) {
		while(i>0)
		{
			ptr1 = ptr1.next;
			i--;
		}
	
		return ptr1;
	}
}

