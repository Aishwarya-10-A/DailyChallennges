/*Given two integers a and b, return the sum of the two integers without using the operators +.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
*/
package DAY20;
import java.util.*;
public class SUM
{
    public static int Sum(int a, int b)
    {
        return b == 0?a:Sum(a^b,(a&b)<< 1);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
      
        System.out.println("Output: " +Sum(a,b));
    }
    
}
