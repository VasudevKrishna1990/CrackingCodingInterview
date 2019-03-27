package _002_LinkedList;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		
		Node root = new Node('a');
		root.next= new Node('b');
		root.next.next= new Node('c');
		root.next.next.next= new Node('d');
		root.next.next.next.next= new Node('e');
		root.next.next.next.next.next= new Node('f');
		root.printList(root);
		deletetheMiddleNode(root.next.next);
		root.printList(root);
	}

	private static void deletetheMiddleNode(Node next) {
		
		Node ptr = next;
		Node prev=null;
		while(ptr.next!=null)
		{
			prev = ptr;
			ptr.ch = ptr.next.ch;
			ptr = ptr.next;
		}
		prev.next = null;
		
	}
	
}


class Node{
	char ch;
	Node next;
	static int length;
	int visited;
	Node (char ch)
	{
		this.ch = ch;
		this.next = null;
		this.setLength();
	}
	public void printList(Node root)
	{
		while(root != null)
		{
			System.out.print(root.ch + " ->");
			root= root.next;
		}
		System.out.println("End");
	}
	public int getLength()
	{
		return length;
	}
	public void setLength()
	{
		 this.length++;
	}
	public boolean isVisited() {
		return (visited == 1)?true:false;
	}
	public void printNode(Node root)
	{
		Node ptr = root;
		while(ptr!=null)
		{
			System.out.print(ptr.ch + " -> ");
			ptr = ptr.next;
		}
		System.out.println("Null");
	}
}