class Solution {
    int[] weights;
    Random random;
    public Solution(int[] w) {
        this.random = new Random();
        //prefix sum
        for(int i = 1; i < w.length; i++)
            w[i] += w[i-1];
        this.weights = w;
    }
    
    public int pickIndex() {
        int len = weights.length;
        //randomly select in range 0, last element of prefix sum(probability becomes of equal to wieght)
        int idx = random.nextInt(weights[len-1])+1;
        int low = 0, high = len-1;
        //return original index bof element by doing binary search
        while(low < high)
        {
            int mid = low+(high-low)/2;
            if(weights[mid] == idx) return mid;
            else if(idx > weights[mid]) low = mid+1;
            else high = mid;
                
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */