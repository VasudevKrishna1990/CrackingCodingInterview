package _003_StackAndQueues;

import java.util.Scanner;

/*
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
(that is, pop ( ) should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 * */
public class StackofPlates {

	static int maxStackSize;
	static int[][] theStack;
	public static void main(String[] args) {
		int[] theInput = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		//Scanner in = new Scanner(System.in);
		maxStackSize = 3;//in.nextInt();
		theStack = new int[10][maxStackSize];
		stackOfPlates(theInput);
	}
	private static void stackOfPlates(int[] theInput) {
		int Cntr = 0;
		StackPlate stackPlate = new StackPlate(theStack,maxStackSize);
		while(theInput.length > Cntr)
		{
			stackPlate.pushStack(theInput[Cntr++]);
		}
		System.out.println("End");
	}
}


class StackPlate{
	static int top;
	static int stackNo;
	int[][] theStack;
	int threshold;
	
	
	public StackPlate(int[][] theStack,int maxStackSize) {
		top = -1;
		stackNo = 0;
		this.theStack = theStack;
		threshold = maxStackSize;
	}

	public void pushStack(int value)
	{
		if(top < theStack[0].length)
		{
			if(top >= this.threshold-1) {
				top = -1;
				theStack[++stackNo][++top] = value;
				
			}
			else {	
				theStack[stackNo][++top] = value;
			}
		}
	}
	
	public void popStack()
	{
		int value = theStack[stackNo][top--];
		if(top < 0 )
		{
			stackNo --;
		}
		System.out.println("The poped value is " +value);
	}
	
}