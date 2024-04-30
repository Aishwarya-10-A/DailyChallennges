/*You are starving and you want to eat food as quickly as possible. 
You want to find the shortest path to arrive at any food cell.
You are given an m x n character matrix, grid , of these different types of cells:
'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.
Return the length of the shortest path for you to reach any food cell.
If there is no path for you to reach food, return -1 .


Note: The first line of the input contains the size of array followed by array elements.

Example=1

input=4 6
X X X X X X
X * O O O X
X O O # O X
X X X X X X
output=3
Explanation: It takes 3 steps to reach the food.

Example=2
 */
import java.util.*;
public class Solution {
    public static int findShortestPathToFood(char[][] grid) {
       
        Queue<int[]> queue = new LinkedList<>(); 
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == '*') {
                    queue.add(new int[]{1, 0, row, col});
                }
            }
        }
        int shortestPathLength = -1;
        boolean[][] visited = new boolean[numRows][numCols];

       
        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();

            if (currentCell[0] == 2) {
                shortestPathLength = currentCell[1];
                break;
            }

            for (int[] direction : directions) {
                int newRow = direction[0] + currentCell[2];
                int newCol = direction[1] + currentCell[3];

                if (newRow >= 0 && newRow < numRows
                        && newCol >= 0 && newCol < numCols
                        && (grid[newRow][newCol] == 'O'
                        || grid[newRow][newCol] == '#')
                        && !visited[newRow][newCol]) {
                    
                    visited[newRow][newCol] = true;
                    if (grid[newRow][newCol] == '#') {
                        queue.add(new int[]{2, currentCell[1] + 1, newRow, newCol});
                    }
                    else {
                        queue.add(new int[]{3, currentCell[1] + 1, newRow, newCol});
                    }
                        }
            }
        }
        return shortestPathLength;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char[][] grid=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(findShortestPathToFood(grid));
    }
}
