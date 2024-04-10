package DAY19;
/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:
input =2
output =0 1 1
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

input =5
output =0 1 1 2 1 2

Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

 */
public class NumberofOnes
{
    public int[] count(int n)
    {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]+=Integer.bitCount(i);
        }
        return arr;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Solution s=new Solution();
        int[] result = s.count(n); 
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
    
}
