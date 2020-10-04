
/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer> > res = new ArrayList<>();
        //If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
        for(int i = 0; i < nums.length && nums[i]<=0; ++i)
        {
            //If the current value is the same as the one before, skip it.
            if(i == 0 || nums[i-1]!=nums[i])
            {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    
     void twoSum(int[] nums, int i, List<List<Integer>> res) {
         HashSet<Integer> seen = new HashSet<>();
         for(int j = i+1; j< nums.length; j++)
         {
             //Compute complement value as -nums[i] - nums[j].
             int complement = -nums[i]-nums[j];
             if(seen.contains(complement))
             {
                 res.add(Arrays.asList(nums[i], nums[j], complement));
                 //Increment j while the next value is the same as before to avoid duplicates in the result.
                 while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
                 
             }
             seen.add(nums[j]);
         }
         
     }
}