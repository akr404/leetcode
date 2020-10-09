
/*
The first time we saw target 3 is at index 2. The count is 0. Our reservoir only have 0 and we need to pick rnd.nextInt(++count) == 0. 
The probability is 1. Result = 2.
Then we went to index 3. The count is 1. Our reservoir is has [0,1]. 
We say if we get 0, we'll change the the result, otherwise we keep it. Then chance that we keep the result=2 is 1/2 which means we got 1 from the reservoir.
Then we went to index 4. count =2. Our reservoir has [0,1,2]. Same as before, if we get 0, then we'll change the result. The chance we get 0 is 1/3, while the chance we didn't get is 2/3. i.e The chance we keep the result ==2 is 2/3.
The chance we get index=2 is 1*1/2*2/3=1/3
*/
class Solution {

    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }
        
        return result;
    }
}
