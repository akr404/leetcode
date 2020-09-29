class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);
        
        int cur = 0, longest = Integer.MIN_VALUE;
        for(int num: nums)
        {
            if(hs.contains(num))
            {
                cur = 0;
                while(hs.contains(num+1))
                {
                    cur+=1;
                    num=num+1;
                }
                longest = Math.max(cur, longest);
            }
        }
        return Math.max(cur, longest)+1;
    }
}