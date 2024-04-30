package DAY22;

import java.util.Scanner;

/*write a program to read a binary string from the user and print its 2's compliment 

1’s complement of a binary number is obtained by changing all bits in it, i.e., changing  the 0 bit to 1 and the 1 bit to 0.

2's complement = 1's complement + 1

Examples:

1's complement of "+0111" is "1000"
1's complement of "1100" is  "0011" 

Examples:
2's complement of "0111" is  "1001"
2's complement of "1100" is  "0100" 

Input - String which contains only '1' and '0'
Output - 2's complement of the given input number 

Sample Test Case - 1
input = 0111
output = 1001

Explanation - 
the input number when converted to 1s complement we have 1000 
and when we add 1 to 1000 we have 1001

1000 + 1 we will have last bit 0 added to 1 which is 1 we get 1001

Sample Test Case - 2
input = 1100
output = 0100

Explanation -
the input number when converted to 1s complement we have 0011
and when we add 1 to 0011 we have 0100 

Here adding will done from the last 
when we add two 1 bits  we get 10 as the result and 1 is carry forwarded 
so we get 0100 as the result  */
public class Compliment
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String bin = sc.next();
        String twos = findTwosComplement(bin);
        System.out.println(twos);
    }

    public static String findTwosComplement(String binNum)
    {
        StringBuilder twos = new StringBuilder();
        for (char bit : binNum.toCharArray())
        {
            if (bit == '0')
            {
                twos.append('1');
            }
            else
            {
                twos.append('0');
            }
        }
        for (int i = twos.length() - 1; i >= 0; i--)
        {
            if (twos.charAt(i) == '0')
            {
                twos.setCharAt(i, '1');
                break;
            }
            else
            {
                twos.setCharAt(i, '0');
            }
        }
        return twos.toString();
    }
    
}
