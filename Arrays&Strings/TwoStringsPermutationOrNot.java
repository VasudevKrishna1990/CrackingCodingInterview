package _001_ArraysandStrings;

import java.util.Arrays;

/*ABC 
BCA

NITIN
INTNI

DALDA
DALAD

BARFI
BARFC


APPLE
APPEAL

*/
/*Key Points 
 * 1: Check Length 
 * 2: Sort character wise and check each char 
 * 3: */

public class TwoStringsPermutationOrNot {

	
	
	public static void main(String[] args) {
		
		String str1 = "NTINI";
		String str2 = "NITIN";
		//boolean result = compare_N_2(str1,str2);
		//boolean result = compare_N_LogN(str1,str2);
		boolean result = compare_N(str1,str2);
		System.out.println(result);
		
	}

	private static boolean compare_N(String str1, String str2) {
		int[] theArray_1 = new int[97];
		int[] theArray_2 = new int[97];
		
		for(int i =0;i<str1.length();i++)
		{
			theArray_1[str1.charAt(i)] = theArray_1[str1.charAt(i)]+1;
			theArray_2[str2.charAt(i)] = theArray_2[str2.charAt(i)]+1;
		}
		int Sum_1 =0;
		int Sum_2 =0;
		for(int i =0;i<theArray_1.length;i++)
		{
			if(theArray_1[i]!=0)
				Sum_1 += theArray_1[i]* (i-64);
			if(theArray_2[i]!=0)
				Sum_2 += theArray_2[i]* (i-64);
			
		}
		return Sum_1==Sum_2;
	}

	private static boolean compare_N_LogN(String str1, String str2) {
	
		if(str1.length() != str2.length()) {
			
			return false;
		}
		
		char[] theArray_1 = str1.toCharArray();
		char[] theArray_2 = str2.toCharArray();
		
		Arrays.sort(theArray_1);
		Arrays.sort(theArray_2);
		String str_1 = new String(theArray_1);
		String str_2 = new String(theArray_2);
		return str_1.equals(str_2);
	}

	private static boolean compare_N_2(String str1, String str2) {
		int length = 0;
		boolean flag =false;
		StringBuilder str_1 = new StringBuilder();
		StringBuilder str_2 = new StringBuilder();
		str_1.append(str1);
		str_2.append(str2);
		if(str_1.length() != str_2.length()) {
		
			return flag;
		}
		else {
			length = str_1.length();
		}
		int i ;
		int j =0;
		for(i=0;i<str_1.length();)
		{
			for( j =0;j<str_2.length();)
			{
				if(str_1.charAt(i) == str_2.charAt(j))
				{
					str_2.replace(j, j+1, " ");
					i++;
					length--;
					if(length == 0) {
						flag = true;
						return flag;
					}
					break;
				}
				else {
					j++;
					if(j>=str_2.length())
						i++;
				}
			}
		}
		return flag;
	}
}
