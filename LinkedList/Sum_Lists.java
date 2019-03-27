package _002_LinkedList;
/*
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .Thatis,617 + 295.
Output: 2 -) 1 -) 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).Thatis,617 + 295.
Output: 9 -) 1 -) 2. That is, 912.
 * 
 * */
public class Sum_Lists extends Remove_Dups{

	public static void main(String[] args) {
	
		List number_001= new List(6);
		number_001.next = new List(1);
		number_001.next.next = new List(7);
		
		List number_002= new List(2);
		number_002.next = new List(9);
		number_002.next.next = new List(5);
		
		//int resNum = listSum_BackwardFilling(number_001,number_002);
		int resNum = listSum_ForwardFilling(number_001,number_002);
		System.out.println(resNum);
	}

	private static int listSum_ForwardFilling(List number_001, List number_002) {
		
		StringBuilder num_001 = new StringBuilder();
		StringBuilder num_002 = new StringBuilder();
		
		while(number_001!= null && number_002!=null)
		{
			num_001.append(number_001.value);
			num_002.append(number_002.value);
			number_001 = number_001.next;
			number_002 = number_002.next;
		}
		int num1 = Integer.parseInt(num_001.toString());
		int num2 = Integer.parseInt(num_002.toString());
		num1= num1+num2;
		return num1;
	}

	private static int listSum_BackwardFilling(List number_001, List number_002) {
		List resList = null;
		int q = 0;
		int r = 0;
		List prev = null;
		List start = null;
		while(number_001 != null && number_002 != null)
		{
			resList = new List(0);
			if(start == null)
				start = resList;
			if(prev == null)
				prev = resList;
			else {
				prev.next = resList;
				prev = resList;
			}
			resList.value = number_001.value + number_002.value + q;
			r = resList.value % 10;
			q = resList.value / 10;
			resList.value = r;
			number_001 = number_001.next;
			number_002 = number_002.next;
		}
		StringBuilder str = new StringBuilder();
		while(start !=null)
		{
			str.append(start.value);
			start = start.next;
		}
		
		str.reverse();
		
		return Integer.parseInt(str.toString());
	}
	
}
