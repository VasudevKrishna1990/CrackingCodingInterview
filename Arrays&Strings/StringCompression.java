package _001_ArraysandStrings;

/*String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).*/
public class StringCompression {

public static void main(String[] args) {
	String str = "aabcccccaaa";
	String compressedString = compressString(str);
	String decompressedString = decompressedString(compressedString);
	
	System.out.println("Original String was :" + str);
	System.out.println("Compressed String was :" + compressedString);
	System.out.println("Decomressed String was :" + decompressedString);
	int res = str.compareTo(decompressedString);
	boolean bres = (res == 0);  
	System.out.println("Original String matches decompressed string True or False ? : "+ bres);
}

private static String decompressedString(String compressedString) {
	StringBuilder decompressedString = new StringBuilder();
	demoChar chr = new demoChar();
	
	for(int i=0;i<compressedString.length();)
	{
		chr.ch = compressedString.charAt(i);
		chr.count = Integer.parseInt(String.valueOf(compressedString.charAt(i+1)));
		for(int j =0;j<chr.count ;j++)
		{
			decompressedString.append(chr.ch);
		}
		i +=2;
	}
	
	return decompressedString.toString();
}

private static String compressString(String str) {
	StringBuilder compressedString = new StringBuilder();
	demoChar chr = new demoChar();
	chr.ch = str.charAt(0);
	chr.count = 1;
	for(int i =1;i<str.length();i++)
	{
		if(chr.ch == str.charAt(i))
			chr.count += 1;
		else
		{
			compressedString.append(chr.ch);
			compressedString.append(chr.count);
			chr.ch = str.charAt(i);
			chr.count = 1;
		}
	}
	compressedString.append(chr.ch);
	compressedString.append(chr.count);
	return compressedString.toString();
}	
	
}

class demoChar{
	
	char ch;
	int count;
	demoChar()
	{
		ch = '0';
		count =0;
	}
}