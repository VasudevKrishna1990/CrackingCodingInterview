package _001_ArraysandStrings;
/*
 * URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith "J 13
Output: "Mr%20J ohn%20Smith"
 * 
 * */
public class Urlify {

	public static void main(String[] args) {
		String str = "Mr John Smith         ";
		int strLen = 13;
		char[] theArray = str.toCharArray();
		
		//String resStr = urlify(theArray,strLen);
		String resStr = urlifyCharArrayInPlace(theArray,strLen);
		System.out.println(resStr);
	}

	private static String urlifyCharArrayInPlace(char[] theArray, int strLen) {
		int noOfSpaces =0;
		//for(int cnt =0;cnt<strLen;cnt++)
		for(char str :theArray)
		{
			if(str == ' ')
			{
				noOfSpaces++;
			}
		}
		
		int newStrLen = strLen + noOfSpaces* 3;
		char[] newCharArray = new char[newStrLen];
		
		/*for(char str :newCharArray)*/
		for(int cnt =0;cnt<strLen;cnt++)
		{
			if(theArray[cnt] == ' ')
			{
				newCharArray[cnt] = '%';
				newCharArray[cnt+1] = '2';
				newCharArray[cnt+2] = '0';
			}
			else
			{
				newCharArray[cnt] = theArray[cnt];
			}
		}
		return String.valueOf(newCharArray);
	}

	private static String urlify(char[] theArray,int strLen) {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<strLen;i++)
		{
			if(theArray[i] == ' ')
			{
				
				str.append("%20");
			}
			else
			{
				str.append(theArray[i]);
			}
		}
		
		return str.toString();
	}
}
