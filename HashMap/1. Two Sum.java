class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0; i< nums.length; i++)
        {
            if(!hs.containsKey(target-nums[i]))
                hs.put(nums[i], i);
            else
                return new int[]{hs.get(target-nums[i]), i};
        }
        return new int[]{-1, -1};
    }
}