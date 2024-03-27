package DAY13;

import java.util.Arrays;
import java.util.Scanner;

/*Two Sum Problem with Sorted Input Array

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
find two numbers such that they add up to a specific target number. Let these two numbers be 
numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array 
[index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element 
twice.
Your solution must use only constant extra space.

Example 1:

Input: N=4 numbers = [2,7,11,15], target = 9
Output: [1,2]

Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].  

Example 2:

Input: N=3 numbers = [2,3,4], target = 6
Output: [1,3]

Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: N=2 numbers = [-1,0], target = -1
Output: [1,2]

Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2]
 */
public class Twosum
{
     public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int nums[]=new int[N];
        for(int i=0;i<N;i++)
        {
            nums[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        int result[]=twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int nums[],int target)
    {
        if(nums==null || nums.length<2)
        {
            return new int[0];
        }
        int sum=0;
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            sum=nums[left]+nums[right];
            if(sum==target)
            {
                return new int[]{left+1,right+1};
            }
            if(sum<target)
            {
                left++;
            }
            if(sum>target)
            {
                right--;
            }
            while (left < right && nums[left] == nums[left + 1])
            {
                left++;
            }
            while (left < right && nums[right] == nums[right - 1]) 
            {  
                right--;
            }
        }
        return new int[]{-1,-1};
        
    }
}
