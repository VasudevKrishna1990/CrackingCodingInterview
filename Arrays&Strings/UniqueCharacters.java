package _001_ArraysandStrings;
public class UniqueCharacters {
public static void main(String[] args) {
	String str = "baku";
	long start = System.currentTimeMillis(); 
	//boolean var = bruteForceApproach(str);
	//boolean var = usingExtraDS(str);
	boolean var = withoutUsingExtraDS(str);
	long end =  System.currentTimeMillis();
	System.out.println(var + " " + (end-start));
}

private static boolean withoutUsingExtraDS(String str) {
	/*For characters a-z*/
	boolean flag = true;
	int var = 0;
	for(int i =0;i<str.length();i++)
	{
		int index = str.charAt(i) - 'a';
		if((var &(1<<index)) > 0)
		{
			flag = false;
			break;
		}
		var = (var|(1<<index));
	}
	
	return flag;
}

private static boolean usingExtraDS(String str) {
	char[] theArray = new char[256];
	boolean flag = true;
	for(int i=0;i<str.length();i++)
	{
		if(theArray[str.charAt(i)]==0)
			theArray[str.charAt(i)] = 1;
		else {
			flag = false;
			break;
		}
	}
	
	
	return flag;
}

private static boolean bruteForceApproach(String str) 
{
	
	boolean flag = false;
	for(int i=0;i<str.length();i++)
	{
		for(int j=i+1;j<str.length();j++)
		{
			if(str.charAt(i) == str.charAt(j))
			{
				return flag;
			}
				
		}
	}
	return true;
}
}
