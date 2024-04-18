package DAY21;
/*Given a non-negative integer num, Return its encoding string.

The encoding is done by converting the integer to a string using a secret function that you should
deduce from the following table:

N          0    1    2    3    4    5     6     7 
f(n)      " "  "0"  "1"  "00" "01" "10"  "11" "000"


Example 1:
Input: num = 23
Output: 1000

Example 2:
Input: num = 107
Output: 101100

If n is 0, then f(n) is "". 
If 1 <= n < 3, then f(n) is a binary string with length 1. 
If 3 <= n < 7, then f(n) is a binary string with length 2. 
If 7 <= n < 15, then `f(n) is abinary string with length 3.


Hint :                                                              
1. For the given number num, obtain the number of bits bits for number num + 1, 
where the number of bits means the number of bits remaining after removing leading zeros.
2. Calculate difference as the difference between num + 1 and 2 ^ bits, and return the binary
representation of difference.*/
import java.util.*;
class Encoding
{
    public String encode(int num) 
	{
		StringBuilder sb = new StringBuilder();
		
		double cur = Math.log(num + 1) / Math.log(2);
		int bits = (int)(Math.floor(cur));
		int offset = num +1 - (int)(Math.pow(2, bits));
		while (offset > 0) 
		{
			sb.append(offset % 2);
			offset /= 2;
		}
			int l = sb.length();
			for (int i = l; i < bits; i++) 
			{
				sb.append("0");
			}
			return sb.reverse().toString();
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		System.out.println(new Solution().encode(s));
	}
    
}
