package _003_StackAndQueues;
import java.util.Stack;
/*Sort Stack: Write a program to sort a stack such that the smallest items are
 *on the top. You can use an additional temporary stack, but you may not copy the
 * elements into any other data structure
 *(such as an array). The stack supports the following operations: push, pop,
 * peek, and isEmpty.*/
public class SortStack {

	public static void main(String[] args) {
		
		int[] theInput = {5,3,1,2,4,9,8,6,10,0};
		sortedStack(theInput);
		
	}

	private static void sortedStack(int[] theInput) {
		Stack<Integer> theStackOne = new Stack<>();
		Stack<Integer> theStackTwo = new Stack<>();
		//System.out.println(theStackOne.peek());
		int Cntr = 0;
		while(Cntr < theInput.length)
		{
			addStack(theInput[Cntr++],theStackOne,theStackTwo);
		}
		
		System.out.println("The stack should be sorted by now");
		System.out.println(theStackOne);
	}

	private static void addStack(int value, Stack<Integer> theStackOne, Stack<Integer> theStackTwo) {
		if(theStackOne.isEmpty())
		{
			theStackOne.add(value);
		}
		else if(theStackOne.peek() < value)
		{
			while(!theStackOne.isEmpty())
			{
				if(theStackOne.peek() < value)
					theStackTwo.add(theStackOne.pop());
				else
					break;
			}
			theStackOne.add(value);
			while(!theStackTwo.isEmpty())
			{
				theStackOne.add(theStackTwo.pop());
			}
		}
		else {
			theStackOne.add(value);
		}
		
	}
	
}
