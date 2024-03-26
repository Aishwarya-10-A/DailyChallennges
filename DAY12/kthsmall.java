/*Given an integer array nums of length n and an integer k, 

return the k-th smallest subarray sum.
A subarray is defined as a non-empty contiguous sequence of elements in an array.

A subarray 
sum is the sum of all elements in the subarray.
Example 1:
Input: nums = [2,1,3], k = 4
Output: 3
Explanation: The subarrays of [2,1,3] are:
• [2] with sum 2
• [1] with sum 1
• [3] with sum 3
• [2,1] with sum 3
• [1,3] with sum 4
• [2,1,3] with sum 6
Ordering the sums from smallest to largest gives 1, 2, 3, 3, 4, 6. 
The 4th smallest is 3.
Example 2:
Input: nums = [3,3,5,5], k = 7
Output: 10
Explanation: The subarrays of [3,3,5,5] are:
• [3] with sum 3
• [3] with sum 3
• [5] with sum 5
• [5] with sum 5
• [3,3] with sum 6
• [3,5] with sum 8
• [5,5] with sum 10
• [3,3,5], with sum 11
• [3,5,5] with sum 13
• [3,3,5,5] with sum 16
Ordering the sums from smallest to largest 
gives 3, 3, 5, 5, 6, 8, 10, 11, 13, 16. 
The 7th smallest is 
10.

Constraints:
• n == nums.length
• 1 <= n <= 2 * 10^4
• 1 <= nums[i] <= 5 * 10^4
• 1 <= k <= n * (n + 1) / 2
*/
package DAY12;
import java.util.*;
class Kthsmall
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.print(new Kthsmall().ksmall(arr, k));
    }

    public int ksmall(int[] nums, int k)
    {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums)
        {
            min = Math.min(min, num);
            sum += num;
        }
        int low = min, high = sum;
        while (low < high)
        {
            int mid = (high - low) / 2 + low;
            int count = countSubarrays(nums, mid);
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int countSubarrays(int[] nums, int k)
    {
        int count = 0;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length)
        {
            sum += nums[right];
            while (sum > k)
            {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
