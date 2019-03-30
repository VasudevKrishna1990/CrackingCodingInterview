package _003_StackAndQueues;

public class TwoStacksInArray {

	int top1 =-1;
	int top2 =-1;
	static int[] theArray = new int[10];
	public static void main(String[] args) {
		implementTwoArrays();
	}

	private static void implementTwoArrays() {
		
		Stack stackOne = new Stack(theArray);
		Stack stackTwo = new Stack(theArray);
		stackOne.pushStackOne(10);
		stackOne.pushStackOne(20);
		stackOne.pushStackOne(30);
		stackOne.pushStackOne(40);
		stackOne.pushStackOne(50);
		stackOne.pushStackOne(60);
		stackOne.pushStackOne(70);
		stackOne.pushStackOne(80);
		stackTwo.pushStackTwo(-10);
		stackTwo.pushStackTwo(-20);
		stackTwo.pushStackTwo(-30);
		stackTwo.pushStackTwo(-40);
		stackOne.popStackOne();
		stackOne.popStackOne();
		stackOne.popStackOne();
		stackOne.popStackOne();
		stackOne.pushStackOne(60);
		stackTwo.pushStackTwo(-50);
		stackTwo.pushStackTwo(-60);
		stackTwo.pushStackTwo(-70);
		stackTwo.pushStackOne(-70);
		System.out.println();
	}
}

class Stack{
	static int top1;
	static int top2;
	int[] theArray;
	
	public Stack(int[] theArray)
	{
		this.top1 = -1;
		this.theArray = theArray;
		this.top2 = theArray.length ;
	}
	
	public void pushStackOne(int value)
	{
		if(top1 < top2-1)
		{
			theArray[++top1] = value;
		}
		else {
			System.out.println("Stack1 is full");
		}
	}
	
	public void pushStackTwo(int value)
	{
		if(top1+1 < top2)
		{
			theArray[--top2] = value;
		}
		else {
			System.out.println("Stack2 is full");
		}
	}
	
	public void popStackOne()
	{
		if(top1 >-1)
		{
			System.out.println(theArray[top1]);
			top1 -=1;
		}
		else {
			System.out.println("Stack1 Empty");
		}
	}
	
	public void popStackTwo()
	{
		if(this.top2 < theArray.length)
		{
			System.out.println(theArray[top2]);
			top2 +=1;
		}
		else {
			System.out.println("Stack2 Empty");
		}
	}
}

class Stack1{
	int top;
	int max ;
	int[] theArray;
	public Stack1(int[] theArray) {
		this.top = -1;
		this.theArray = theArray;
	}
	
	public void insert(int value)
	{
		if(this.top < theArray.length-1)
		{
			theArray[++top] = value;
		}
		else {
			System.out.println("Stack is full");
		}
	}
	
	public void delete()
	{
		if(this.top > -1)
		{
			theArray[top--] = 0;
		}
		else {
			System.out.println("Stack is Empty");
		}
	}
	public int getTop()
	{
		return this.top;
	}
	
}

class Stack2{
	int top;
	int max;
	int[] theArray;
	
	public Stack2(int[] theArray) {
		this.top = theArray.length;
		this.theArray = theArray;
	}
	public void insert(int value)
	{
		if(this.top > -1 )
		{
			theArray[--top] = value;
		}
		else {
			System.out.println("Stack is full");
		}
	}
	
	public void delete()
	{
		if(this.top < theArray.length -1)
		{
			theArray[top++] = 0;
		}
		else {
			System.out.println("Stack is Empty");
		}
	}
	public int getTop()
	{
		return this.top;
	}
}