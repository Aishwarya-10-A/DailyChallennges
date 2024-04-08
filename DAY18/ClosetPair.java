package DAY18;
/*
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the
pair has an element from each array.

We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find 
the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.



Note: The first line of the input contains the size of array 
followed by first array elements followed by second array elements followed by x.


Example-1:

Input: ar1[] = {1, 4, 5, 7};
 ar2[] = {10, 20, 30, 40};
 x = 32 
Output: 1 and 30


Example-2:

Input: ar1[] = {1, 4, 5, 7};
 ar2[] = {10, 20, 30, 40};
 x = 50 
Output: 7 and 40

*/

public class ClosetPair
{
    public static void closestPair(int a1[], int a2[], int m,int x)
    {
        if (m == 0 )
        {
           
            return;
        }

        int l = 0;
        int r = m - 1;
        int diff = Integer.MAX_VALUE;
        int res_l = 0;
        int res_r = 0;

        while (l < m && r >= 0)
        {
            if (Math.abs(a1[l] + a2[r] - x) < diff)
            {
                res_l = l;
                res_r = r;
                diff = Math.abs(a1[l] + a2[r] - x);
            }
            if (a1[l] + a2[r] > x)
            {
                r--;
            } 
            else
            {
                l++;
            }
        }
        System.out.println(a1[res_l] + "and" + a2[res_r]); 
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
       // int n = sc.nextInt();
        
        if (m == 0 )
        {
            System.out.println("No Pair");
            return;
        }

        int a1[] = new int[m];
        for (int i = 0; i < m; i++)
        {
            a1[i] = sc.nextInt();
        }

        int a2[] = new int[m];
        for (int i = 0; i < m; i++)
        {
            a2[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        closestPair(a1, a2, m, x);
    }
}
