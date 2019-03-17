package _001_ArraysandStrings;

public class One_Away {

	
	public static void main(String[] args) {
		String str1 = "palestrq";
		String str2 = "palaserq";
		System.out.println(OneAway_bruteForce(str1,str2));		
		//System.out.println(OneAway(str1,str2));
	}

	private static char[] OneAway(String str1, String str2) {
		
		return null;
	}

	private static boolean OneAway_bruteForce(String str1, String str2) 
	{
		int i = 0;
		int j = 0;
		int ignoreCount =0;
		boolean flag = false;
		
		int res = str1.compareTo(str2);
		if(res == 0)
			flag = true;
		else {
			/*diff > 1*/
			int diff =0;
			if(str1.length()> str2.length())
			{
				diff = str1.length() - str2.length();
			}
			else 
			{
				diff = str2.length() - str1.length();
			}
			
			if(diff>1) {
				flag = false;
				return flag;
			}
			
			/*if one diff is there*/
			flag = true;
			while(i<str1.length() && j<str2.length())
			{
				if(str1.charAt(i)!= str2.charAt(j))
				{
					++ignoreCount;
					if(ignoreCount>1) {
						flag = false;
						break;
					}
					if(str1.charAt(i+1) == str2.charAt(j))
						i++;
					else if(str1.charAt(i) == str2.charAt(j+1))
						j++;
					else
					{
						i++;j++;
					}
				}
				else {
					i++;
					j++;
					continue;
				}
			}
		}
		if((i== str1.length()) && j<str2.length()) {
			flag = false;
		
		}
		else if((i < str1.length()) && (j == str2.length()))
		{
			flag = false;
		}
		return flag;
	}
}
