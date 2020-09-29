/*
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

 

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
*/

class Solution {
    public int missingElement(int[] A, int k) {
        int left = 1, right = A.length;
        int target = A[0] + k;
        //avoid binary search if k > last missing
        int num = A[right - 1] - A[0] - right + 1;
        if (num < k) {
            return A[right - 1] - num + k;
        }
        //binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target + mid - 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return target + left - 1;
    }
}