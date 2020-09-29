class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length-1; 
        k = nums.length-k;
        while(low < high)
        {
            int j = partition(nums, low, high);
            if(j > k)
                high = j-1;
            else if(j < k)
                low = j+1;
            else
                break;
        }
        return nums[k];
    }
    
    public int partition(int[] nums, int low, int high)
    {
        int pivot = nums[high];
        int i = low;
        for(int end = low; end < high; end++)
        {
            if(nums[end] <= pivot)
            {
                swap(nums, i, end);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }
     public void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}