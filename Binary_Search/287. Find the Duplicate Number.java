class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i< nums.length; i++)
        {
            int n = nums[i];
            System.out.println(n);
            n--;
            if(n >= 0)
            {
                nums[n] = -1 * nums[n];
            }
            else
            {
                return nums[i]*-1;
            }
            
        }
        
        return 0;
    }
}