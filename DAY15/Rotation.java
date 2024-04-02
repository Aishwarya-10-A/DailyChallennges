package DAY15;

import java.util.*;

/*Given an array, rotate the array to the right by k steps, where k is non-negative. For example, if 
our input array is [a, b, c, d, e] and k is 2, then the output should be [d, e, a, b, c].
We can solve this by having two loops again which will make the time complexity O(n^2) or by 
using an extra, temporary array, but that will make the space complexity O(n).

example
input=5
a b c d e
2
output=d e a b c
 */
public class Rotation
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char letters[]=new char[n];
        for(int i=0;i<n;i++)
        {
            letters[i]=sc.next().charAt(0);
        }
        int k=sc.nextInt();
        rotate(letters, k);
        for(int i=0;i<letters.length;i++)
        {
            System.out.print(letters[i] + " ");
        }
    }
    public static void rotate(char[] letters,int k)
    {
        if (letters==null || letters.length==0 || k%letters.length==0)
        {
            return;
        }

        k=k%letters.length;
        for (int i=0;i<k;i++)
        {
            char temp = letters[letters.length - 1];
            for (int j=letters.length-1;j>0;j--)
            {
                letters[j]=letters[j-1];
            }
            letters[0]=temp;
        }
    }
    
}
