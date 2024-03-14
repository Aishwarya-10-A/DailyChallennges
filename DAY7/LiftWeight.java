/*In a shopping mall, there is a Lift with a capacity of 500kgs only.
There are N persons waiting for the lift, and their weights (weights[]) are given.
If The Lift is overloaded, it will not move.
 
Your task is to find out the maximum number of persons can use the Lift,
without any overloading issue.

Input Format:
-------------
Line-1: An integer N, number of persons
Line-2: N space separated integers, weights of the persons.

Output Format:
--------------
Print an integer, max num of persons canuse the lift.


Sample Input-1:
---------------
6
98 121 76 135 142 65

Sample Output-1:
----------------
5


Sample Input-2:
---------------
7
85 67 69 83 54 61 50

Sample Output-2:
----------------
7
 */

import java.util.*;
class LiftWeight
{
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      if(n<=0)//edge case
      {
          return;
      }
      int arr[]=new int[n];
      for(int i=0;i<n;i++)
      {
          arr[i]=sc.nextInt();
          if(arr[i]<=0)//edge case
          {
              return;
          }
      }
      int result=liftWeight(arr);
      System.out.print(result);
    }
    public static int liftWeight(int arr[])
    {
        int n=arr.length;
        int count=0;
        int sum=0;
        
        if(arr.length==0)//edge case
        {
            return 0;
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            count++;
            if(sum>500)
            {
                count--;
                break;
            }
            
        }
        return count;
    }
}