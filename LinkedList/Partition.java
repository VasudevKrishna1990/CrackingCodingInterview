package _002_LinkedList;

public class Partition extends Remove_Dups {

	public static void main(String[] args) {
		List root =  new List(3);
		root.next = new List(5);
		root.next.next  = new List(8);
		root.next.next.next  = new List(5);
		root.next.next.next.next  = new List(10);
		root.next.next.next.next.next  = new List(2);
		root.next.next.next.next.next.next  = new List(1);
		printList(root);
		int value = 5;
		List resList = partitionList(root,value);/*Using Extra space*/
		//List resList = partitionList_WithoutExtraSpace(root,value);/*Without extra space*/
		printList(resList);
		
	}
	private static List partitionList_WithoutExtraSpace(List root, int value) {
		List ptr= root;
		while(ptr!=null)
		{
			if(value > ptr.value)
			{
				
			}
		}
		
		
		return null;
	}
	private static List addBeg(int newNode,int value,List newList)
	{
		List newValue = new List(newNode);
		newValue.next = newList;	
		return newValue;
	}
	private static List addEnd(int newNode,int value,List newList)
	{
		List ptr = newList;
		while(ptr.next!=null)
		{
			ptr= ptr.next;
		}
		ptr.next = new List(newNode);
		return newList;
	}
	private static List partitionList(List root,int value) {
		List newList = new List(value);
		int ignoreCount = 1;
		newList.next= null;
		List ptr = root;
		while(ptr != null)
		{
			if(value <= ptr.value) {
				if(ignoreCount > 0 && ptr.value == value) {
					ignoreCount -=1;
				}
				else {
				newList = addEnd(ptr.value,value,newList);
				}
			}
			else {
				newList = addBeg(ptr.value,value,newList);
			}
			ptr = ptr.next;
		}
		return newList;
	}
}
