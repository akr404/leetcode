/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
*/
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        if(nums.length == 0) return false;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) return true;
            else if(nums[low] == nums[mid] && nums[high] == nums[mid])
            {
                low++;
                high--;
            }
            else if(nums[mid] >= nums[low])
            {
                if(target >= nums[low] && target < nums[mid]) high = mid-1;
                else low = mid+1;
            }
            else
            {
               if(target <= nums[high] && target > nums[mid]) low = mid+1;
                else high = mid-1;
            }
        }
        return false;
        
    }
}