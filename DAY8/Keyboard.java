/*Amazon fire tv stick keyboard wanted to be operated on number pad. 
You will be given the below pad. 
You are supposed to print all possible words in alphabetic order for a given number (0-9)

	1		2		3
		   abc	   def
		 
	4		5		6
   ghi             jkl     mno
  
	7		8		9
  pqrs           tuv    wxyz
	
	*		0		#


You will be given a string S which contains (2-9)  only  
For example: S = "3", then the possible words are "d", "e", "f".

Input Format:
-------------
String(2-9)

Output Format:
--------------
Print the list of words in alphabetical order


Sample Input-1:
---------------
2

Sample Output-1:
----------------
a b c


Sample Input-2:
---------------
24

Sample Output-2:
----------------
ag ah ai bg bh bi cg ch ci

*/
import java.util.*;
public class Keyboard 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        String[] phone_map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack("", digits, phone_map);
    }

    private static void backtrack(String combination, String next_digits, String[] phone_map) 
    {
        if (next_digits.isEmpty())
        {
            System.out.print(combination+" ");
            return;
        } 
        else 
        {
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) 
            {
                backtrack(combination + letter, next_digits.substring(1), phone_map);
            }
        }
    }

    
}
