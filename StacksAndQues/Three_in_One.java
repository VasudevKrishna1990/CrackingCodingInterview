package _003_StackAndQueues;

import java.util.Arrays;
import java.util.Scanner;

/*Three in One: Describe how you could use a single array to implement three stacks.*/
public class Three_in_One {
	static int[] theArray = new int[15];
	public static void main(String[] args) {
		int[] theArray = new int[15];
		System.out.println("Enter the no of stacks you would like to create");
		Scanner in = new Scanner(System.in);
		int noOfStacks = in.nextInt();
		createStacksInArray(noOfStacks);
		
	}

	private static void createStacksInArray(int noOfStacks) {
		
		StackDS stack = new StackDS(3,theArray);
		
		stack.pushStack(1, 1);
		stack.pushStack(2, 2);
		stack.pushStack(3, 3);
		stack.pushStack(1, 1);
		stack.pushStack(2, 2);
		stack.pushStack(3, 3);
		stack.pushStack(1, 1);
		stack.pushStack(2, 2);
		stack.pushStack(3, 3);
		stack.pushStack(1, 1);
		stack.pushStack(2, 2);
		stack.pushStack(3, 3);
		stack.pushStack(1, 1);
		stack.pushStack(2, 2);
		stack.pushStack(3, 3);
		stack.popStack(1);
		stack.popStack(2);
		stack.popStack(3);
		stack.popStack(1);
		stack.popStack(2);
		stack.popStack(3);
		stack.popStack(1);
		stack.popStack(2);
		stack.popStack(3);
		stack.popStack(1);
		stack.popStack(2);
		stack.popStack(3);
		stack.popStack(1);
		stack.popStack(2);
		stack.popStack(3);
		System.out.println("End");
	}
}

class StackDS{
int[] topArray ;
static int noOfStacks;
int[] theArray;
public StackDS(int noOfStacks,int[] theArray)
{
	this.theArray = theArray;
	this.topArray = new int[noOfStacks];
	this.noOfStacks = noOfStacks;
for(int i=0;i<topArray.length;i++)
	topArray[i] = i;
}

public void pushStack(int value,int stackNo)
{
	if(topArray[stackNo-1] < theArray.length)
	{
		theArray[topArray[stackNo-1]] = value;
		topArray[stackNo-1] = topArray[stackNo-1] + noOfStacks;
	}
	else {
		System.out.println("The Stack "+stackNo+ " space is full");
	}
}

public void popStack(int stackNo) 
{
	int value = 0;
	if(topArray[stackNo-1] > 2)
	{
		value = theArray[topArray[stackNo-1]-noOfStacks];
		topArray[stackNo-1] -= noOfStacks;
		System.out.println(value);
	}
	else {
		System.out.println("The stack "+stackNo+" is Empty");
	}
}
	
}