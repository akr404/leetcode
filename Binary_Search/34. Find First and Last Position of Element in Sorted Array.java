//o(logn) two binary searches
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[2];
        if(nums.length == 0){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        else
        {
            //search leftmost
            res[0] = binarySearch(nums, target, 1);
            //search rightmost index
            res[1] =  binarySearch(nums, target, -1);
        }
        
       return res;
    }
    public int binarySearch(int[] a, int x, int direction)
    {
        int low = 0, high = a.length-1;
        int index = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(a[mid] == x)
            {
                index = mid;
                if(direction == 1)
                   high = mid-1;
                else
                    low = mid+1;
            }
            else if(x < a[mid]) high = mid-1;
            else low = mid+1;
        }
        return index;
    }
}


//O(k) complexity where k is rannge, worse case o(n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x = binarySearch(nums, target);
        int[] res = new int[2];
        if(x == -1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        else
        {
            int i = x, j = x;
            while(i >=0 && nums[i] == target) i--;
            while(j <nums.length && nums[j] == target) j++;
            
            res[0] = i+1;
            res[1] = j-1;
        }
        
       return res;
    }
    public int binarySearch(int[] a, int x)
    {
        int low = 0, high = a.length-1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(a[mid] == x) return mid;
            else if(x < a[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}