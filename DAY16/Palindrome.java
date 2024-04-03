package DAY16;

import java.util.Scanner;

/* Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string -1.

A string is palindromic if it reads the same forward and backward.


Input: 
input =5
abc car ada racecar cool
output =ada
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.


input =2
notapalindrome racecar
output =racecar
Explanation: The first and only string that is palindromic is "racecar".

input =2
def ghi
output =-1
Explanation: There are no palindromic strings, so the -1 is returned.
 
Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists only of lowercase English letters.
*/
import java.util.*;
class Palindrome
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
        String words[] = sc.nextLine().split("\\s+");
        String result = isPalindrome(words);
        System.out.print(result);
    }
    
    public static String isPalindrome(String[] words)
    {
        for (String s : words)
        {
            int left = 0;
            int right = s.length() - 1;
            while (left < right)
            {
                if (s.charAt(left) != s.charAt(right))
                {
                    break;
                }
                left++;
                right--;
            }
            if (left >= right)
            {
                return s;
            }
        }
        return "-1";
    }


    
}
