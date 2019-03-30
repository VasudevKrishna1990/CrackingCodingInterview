package _003_StackAndQueues;
import java.util.Stack;
/*Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.*/
public class QueueAndStacks {
	
	public static void main(String[] args) {
		
		int[] theInput = {1,2,3,4,5,6,7,8,9,10,11,12};
		queueWithStacks(theInput);
	}

	private static void queueWithStacks(int[] theInput) {
		Stack<Integer>stackOne = new Stack<>(); 
		Stack<Integer>stackTwo = new Stack<>();
		int Cntr =0;
		while(theInput.length > Cntr)
		{
			stackOne.add(theInput[Cntr]);
			if(Cntr == 3 ||Cntr == 8 ||Cntr == 5 || Cntr == 7 || Cntr == 11)
				removeStack(stackOne,stackTwo);
			Cntr++;
		}		
		System.out.println("End");
	}

	private static void removeStack(Stack<Integer> stackOne, Stack<Integer> stackTwo) {
		if(stackTwo.isEmpty())
		{
			while(!stackOne.isEmpty())
			{
				stackTwo.add(stackOne.pop());
			}
			
			System.out.println("The popped value is "+stackTwo.pop());
		}
		else {
			System.out.println("The popped value is "+stackTwo.pop());
		}
		
	}

}
