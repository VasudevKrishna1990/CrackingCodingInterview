package _003_StackAndQueues;
/*
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * */
public class StackMin {

	static int[][] theStack = new int[10][2];
	
	public static void main(String[] args) {
		int[] theInput = {5,6,7,1,3,2,4,10,18,0,8};
		theSpecialStack(theInput);
		
	}

	private static void theSpecialStack(int[] theInput) {
		StackArray myStack = new StackArray(theStack);
		myStack.pushStack(theInput[0]);
		myStack.pushStack(theInput[1]);
		myStack.pushStack(theInput[2]);
		myStack.pushStack(theInput[3]);
		myStack.pushStack(theInput[4]);
		System.out.println(myStack.getMin());
		System.out.println(myStack.popStack());
		System.out.println(myStack.popStack());
		myStack.pushStack(theInput[5]);
		System.out.println(myStack.getMin());
		myStack.pushStack(theInput[6]);
		System.out.println(myStack.getMin());
		myStack.pushStack(theInput[7]);
		myStack.pushStack(theInput[8]);
		System.out.println(myStack.getMin());
		myStack.pushStack(theInput[9]);
		myStack.pushStack(theInput[10]);
		System.out.println(myStack.getMin());
	}
}

class StackArray{
	static int currMin;
	static int top;
	int[][] theArray;
	public StackArray(int[][] theStack) {
		this.theArray = theStack;
		this.currMin = 9999;
		this.top =-1;
	}

	public void pushStack(int value) {
		this.theArray[++this.top][0] = value;
		if(this.currMin > value) {
			this.theArray[top][1] = value;
			this.currMin = value;
		}
		else {
			this.theArray[top][1] = currMin;
		}
	}
	
	public int popStack() {
		int value = theArray[this.top][0]; 
		currMin = theArray[--this.top][1];
		System.out.print("Popped out value is ");
		return value;
	}
	
	public int getMin()
	{
		System.out.print("Curr Min ");
		return this.currMin;
	}
}

