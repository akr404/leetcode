class Solution {
    public int trap(int[] a) {
        int maxLeft = 0, maxRight = 0, left = 0, right = a.length-1, result =0;
        while(left < right)
        {
            if(a[left] < a[right])
            {
                if(a[left] >= maxLeft) maxLeft =a[left];
                else result = result + (maxLeft - a[left]);
                left++;
                
            }
            else
            {
                if(a[right] >= maxRight) maxRight =a[right];
                else result = result + (maxRight - a[right]);
                right--;
            }
        }
        return result;
    }
}