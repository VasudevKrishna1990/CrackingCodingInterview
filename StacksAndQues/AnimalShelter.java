package _003_StackAndQueues;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/*
Animal Shelter: An animal shelter, which holds only dogs and cats,
operates on a strictly"first in, first
out" basis. People must adopt either the "oldest"
(based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat
(and will receive the oldest animal of
that type). They cannot select which specific animal they would like.
Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny,
dequeueDog,and dequeueCat. You may use the built-in Linked List data
structure.
*/
public class AnimalShelter {

	public static void main(String[] args) {
		int Cntr =0;
		Queue<LinkedList>theQueue = new LinkedList<>();
		char[] theArray = {'D','D','D','C','C','D','C','D','D','C'};
		while(Cntr < theArray.length)
		{
			char c = theArray[Cntr++];
			LinkedList temp= new LinkedList<>();
			temp.add(c);
			theQueue.add(temp);
		}
		animalShelter(theQueue);
		System.out.println();
	}

	private static void animalShelter(Queue<LinkedList> theQueue) {
		Scanner in  = new Scanner(System.in);
		boolean exit = true;
		while(exit)
		{
			System.out.println("!!!  Enter choice as per menu !!!");
			System.out.println("oldest : For Oldest animal in husbandry");
			System.out.println("cat : For Oldest Cat in husbandry");
			System.out.println("dog : For Oldest Dog in husbandry");
			System.out.println("exit : To exit from Animal husbandry");
			String choice = in.nextLine();
			switch(choice)
			{
			case "oldest":
				System.out.println("Oldest animal is ");
				theQueue.remove();
				System.out.println(theQueue);
			break;
			case "dog":
				System.out.println("Oldest dog is ");
				//theQueue.remove('D');
				deleteNode(theQueue,'D');
				System.out.println(theQueue);
				break;
			case "cat":
				System.out.println("Oldest cat is ");
				//theQueue.remove('C');
				deleteNode(theQueue,'C');
				System.out.println(theQueue);
				break;
			case "exit":
				System.out.println("Exiting ...");
				exit = false;
				break;
			default:
				System.out.println("The Animal Husbandry !!! At ur service ");
				System.out.println(theQueue);
				break;
			}
		
		}
	}

	private static void deleteNode(Queue<LinkedList> theQueue, char c) {
		LinkedList temp = new LinkedList<>();
		Iterator itr = theQueue.iterator();
		char[] theChar ;
//		Set<Map.Entry<String,Integer>>theEntrySet = theHashMap.entrySet();
	//	for(Map.Entry<String, Integer>entry:theEntrySet)
		
		while(itr.hasNext())
		{
			temp = (LinkedList)itr.next();
			theChar = temp.toString().toCharArray();
			if(theChar[1] == c) {
				itr.remove();
				break;
			}

		}
	}
		
}
