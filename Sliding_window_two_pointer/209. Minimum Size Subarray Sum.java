class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0;
        int sum = 0, min = Integer.MAX_VALUE;
        while(j < nums.length)
        {
            sum = sum + nums[j++];
            while (sum >= s) {
              min = Math.min(min, j - i);
              sum -= nums[i++];
            }
           
            
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}