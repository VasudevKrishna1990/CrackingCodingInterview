package _001_ArraysandStrings;

public class String_Rotation {

	public static void main(String[] args) {
		String s1 = "1234567";
		String s2 = "4567123";
		
		boolean result = stringRotate(s1,s2);
		System.out.println(result);
	}

	private static boolean stringRotate(String s1, String s2) {
		StringBuilder rotateString = new StringBuilder();
		int count= s1.length();
		boolean flag = false;
		if(count != s2.length())
			return false;
		rotateString.append(s1);
		while(count > 0) {
		rotateString = rotate(rotateString);
		if(rotateString.toString().compareTo(s2) != 0)
		{
			//rotateString = null;
			count--;
		}
		else {
			flag = true;
			break;
		}
		
		}
		return flag;
	}

	private static StringBuilder rotate(StringBuilder s1) {
		StringBuilder str =new StringBuilder();
		char ch;
		if(!s1.toString().isEmpty())
		{
			ch = s1.charAt(0);
			str.append(s1.substring(1, s1.length()));
			str.append(ch);
		}
		return str;
	}
}
