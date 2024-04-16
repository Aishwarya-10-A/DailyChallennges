package DAY20;
/*We are given an m x n binary matrix grid.

In one operation, you can choose any row or column and flip each value in that rowor column 
(i.e., changing all 0's to 1's, and all 1's to 0's).

Return true if it is possible to remove all 1’s from the grid using any number ofoperations or false 
otherwise.

0 1 0		0 1 0		0 0 0
1 0 1  -->  0 1 0  -->  0 0 0
0 1 0		0 1 0		0 0 0

input=3 3
0 1 0 
1 0 1 
0 1 0
output=true

Explanation: One possible way to remove all 1's from grid is to:
- Flip the middle row
- Flip the middle column

Note: The first line of the input contains the size of array followed by array elements.

Hints  :
1. Compare first row with every row of the matrix.
2. If every row values are equal to first row or reversed row then it is possible to remove all 1’s in the
rows by row and column flips
*/ 
import java.util.*;
public class RemoveOnes {

    public static boolean removeOnes(int[][] grid) 
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
        {
            return false;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) 
        {
            if (!equalRow(grid[i], grid[0])) 
            {
                for (int j = 0; j < n; j++) 
                {
                    grid[i][j] = 1 - grid[i][j];
                }
                if (!equalRow(grid[i], grid[0])) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean equalRow(int[] row1, int[] row2) 
    {
        for (int i = 0; i < row1.length; i++) 
        {
            if (row1[i] != row2[i]) 
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(removeOnes(grid));
    }
    
}
