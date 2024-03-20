/*Given an matrix with no duplicate values, return all lucky numbers in the
matrix.

A lucky number is an element of the matrix such that, it is the maximum element in its row and minimum in its column.

ex:
input =
3 3
3 7 8
9 11 13
15 16 17
output =8
explanantion: 8 is the only lucky number since it is the maximum number in row and minimum in its column.


ex2:
input =
3
4
15 16 17 12
9 3 8 7
1 10 4 2
output =-1
none of the elements in the matrix matches the luckynumber rules. so print -1.

input =
2 2
1 2
7 8
output =2
explanantion: 2 is the only lucky number since it is the maximum number in row and minimum in its column.


 */
import java.util.*;
public class LuckyNumber
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int result = luckynumber(arr);
        System.out.print(result);
    }

    public static int luckynumber(int arr[][])
    {
        int rowMax[] = new int[arr.length];
        int colMin[] = new int[arr[0].length];
        
       
        for (int i = 0; i < arr.length; i++)
        {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arr[0].length; j++)
            {
                max = Math.max(max, arr[i][j]);
            }
            rowMax[i] = max;
        }
        
        
        Arrays.fill(colMin, Integer.MAX_VALUE);

      
        for (int j = 0; j < arr[0].length; j++)
        {
            for (int i = 0; i < arr.length; i++)
            {
                colMin[j] = Math.min(colMin[j], arr[i][j]);
            }
        }

       
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                if (arr[i][j] == rowMax[i] && arr[i][j] == colMin[j])
                {
                    return arr[i][j];
                }
            }
        }
        return -1;
    }
}