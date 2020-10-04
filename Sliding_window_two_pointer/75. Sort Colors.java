class Solution {
    public void sortColors(int[] num) {
        int low = 0, mid = 0, high = num.length-1;
        while(mid <= high)
        {
            // mid is zero, swap with low
            if(num[mid] == 0)
            {
                swap(num, low, mid);
                low++;
                mid++;
            }
            else if(num[mid] == 1)
            {
                mid++;
            }
            else
            {
                // if mid is 2, swap with high
                swap(num, mid, high);
                high--;
            }
        }
        return;
    }
    
    public int[] swap(int[] num, int i, int j)
    {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        return num;
    }
}