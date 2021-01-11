package tri.JavSum;

import javax.xml.stream.events.Characters;

/*
 * Method & Description
1	isLetter()
Determines whether the specified char value is a letter. Character.isLetter('a');

2	isDigit()
Determines whether the specified char value is a digit.

3	isWhitespace()
Determines whether the specified char value is white space.

4	isUpperCase()
Determines whether the specified char value is uppercase.

5	isLowerCase()
Determines whether the specified char value is lowercase.

6	toUpperCase()
Returns the uppercase form of the specified char value.

7	toLowerCase()
Returns the lowercase form of the specified char value.

8	toString()
Returns a String object representing the specified character value that is, a one-character string.
 * 
 * 
 */

public class JavaChar
{
	static int convertInt(char c)
	{
		int num = Character.getNumericValue(c);
		return num;
	}
	
	public static void main(String[] args)
	{
		char ca = 'a';
		char cz	= 'z';
		int ia = (int)ca;
		int iz = (int)cz;
		
		char cA = 'A';
		char cZ = 'Z';
		int iA = (int)cA;
		int iZ = (int)cZ;
		
		System.out.println(ca + " = " + ia + ", " + cz + " =  " + iz);
		System.out.println(cA + " = " + iA + ", " + cZ + " =  " + iZ);

	}

}
