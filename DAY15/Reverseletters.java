package DAY15;

import java.util.Scanner;

/*Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.


example 1

input =ab-cd
output =dc-ba

example 2

input =a-bC-dEf-ghIj
output =j-Ih-gfE-dCba

example 3

input =Test1ng-Leet=code-Q!
output =Qedo1ct-eeLg=ntse-T!


 */
public class Reverseletters
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String reversed = reverseString(s);
        System.out.println(reversed);
    }
    public static String reverseString(String s)
    {
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        while (left < right)
        {
            while (left<right && !Character.isLetter(c[left]))
            {
                left++;
            }
            while (right>left && !Character.isLetter(c[right]))
            {
                right--;
            }
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        return new String(c);
    }
    
}
