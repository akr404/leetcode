/*
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

 

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
*/
public int missingElement(int[] nums, int k) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        int countMissing = nums[len - 1] - nums[0] + 1 - len;

        if (countMissing < k) {
            return nums[len - 1] + k - countMissing;
        }

        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            int newCountMissing = nums[mid] - nums[lo] - (mid - lo);
            // when the number is larger than k, then the index won't be located in (m, h]
            if (newCountMissing >= k) {
                hi = mid;
            }// when the number is smaller than k, then the index won't be located in [l, m), update k -= missing 
            else {
                k -= newCountMissing;
                lo = mid;
            }
        }

        return nums[lo] + k;
    }