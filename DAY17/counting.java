package DAY17;

import java.util.Scanner;

/*The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

It has a length of k.
It is a divisor of num.
Given integers num and k, return the k-beauty of num.

Note:

Leading zeros are allowed.
0 is not a divisor of any value.
A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: num = 240, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "24" from "240": 24 is a divisor of 240.
- "40" from "240": 40 is a divisor of 240.
Therefore, the k-beauty is 2.
Example 2:

Input: num = 430043, k = 2
Output: 2 */
public class counting
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int k=sc.nextInt();
        System.out.print(countkBeauty(num,k));
    }
    public static int countkBeauty(int num,int k)
    {
        int count=0;
        int tempNum=num;
        while(tempNum>0)
        {
            int digitCount=(int)Math.log10(tempNum)+1; 
            if (digitCount >= k)
            {
                int divisor=(int)Math.pow(10,digitCount-k); 
                int substr=tempNum/divisor; 
                if(substr!=0 && num%substr==0)
                {
                    count++;
                }
            }
            
            tempNum%=(int)Math.pow(10,digitCount-1); 
        }
        
        return count;
    }
}
