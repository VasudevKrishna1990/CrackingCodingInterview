package _001_ArraysandStrings;

public class Palindrome_Permutation {

	
	public static boolean isPalindrome(String str)
	{
		for(int i =0,j=str.length() -1 ;i<j;i++,j--)
		{
			if(str.charAt(i) == str.charAt(j))
			{
				continue;
			}
			else {
				if(( i == j))
					return true;
				else
					return false;
			}
		}
		return true;
	}

    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    static boolean var  = false;
    static int v =0;
    private static void permute(String str, int l, int r) 
    { 
    	
	if(v ==0) 
	{
			if (l == r)
		    { 
		        if(isPalindrome(str))
		        {
		        	System.out.println(str);
		        	var = true;
		        	v=1;
		        	return;
		        }
		    }
		    else
		    { 
		        for (int i = l; i <= r; i++) 
		        { 
		            str = swap(str,l,i); 
		            permute(str, l+1, r); 
		            str = swap(str,l,i); 
		        } 
		    } 
    	}
    }  
	
	private static boolean generatePermutations(String str) {
		boolean flag = false;
	    permute(str,0,str.length()-1);
		return var;
	}

public static void main(String[] args) {
		
		String str = "Tact";
		String str1 = str.toLowerCase();
		StringBuilder newStr = new StringBuilder();
		for(int i=0;i<str1.length();i++)
		{
			if(str1.charAt(i)!= ' ')
				newStr.append(str1.charAt(i));
		}
		
		System.out.println(generatePermutations(newStr.toString()));
	}

}
