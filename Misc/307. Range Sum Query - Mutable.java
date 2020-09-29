
//https://www.youtube.com/watch?v=CWDQJGaN1gY&t=486s&ab_channel=TusharRoy-CodingMadeSimple

//https://leetcode.com/problems/range-sum-query-2d-mutable/


class NumArray {
    int[] nums;
    int n;
    int[] binaryindexTree;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.binaryindexTree = new int[n+1];
        for(int i = 0; i < n; i++)
            initBIT(i, nums[i]);
    }
    public void initBIT(int i, int val)
    {
        i = i+1;
        while(i <= n)
        {
            binaryindexTree[i] += val;
            //parent is obtained by siwtching the rightmost set bit to 0
            i += (i & -i);
        }
    }
    public void update(int i, int val) {
        int diff = val - nums[i];

        //update ith node
        nums[i] = val;
        //update other affected node(parents up to 0) //add diff to all other parent node
        initBIT(i, diff);
        
    }
    public int getSum(int i)
    {
        // sum for from 0 to i range, traverse from i to its parent till 0 and store the sum
        int sum = 0;
        i++;
        while(i > 0)
        {
            sum += binaryindexTree[i];
            i -= (i & -i);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        	return getSum(j) - getSum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */