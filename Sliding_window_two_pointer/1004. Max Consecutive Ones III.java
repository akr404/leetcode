class Solution {
    public int longestOnes(int[] A, int K) {
        int res = 0, zeroCount = 0, start = 0, end = 0;
        //window start-end
        for(end = 0; end < A.length; end++)
        {
            //count number of zeroes to be fliped
            if(A[end] == 0 ) zeroCount++;
            if(zeroCount > K)
            {
                //if zeros > k, remove zeroes from start
                if(A[start] == 0) zeroCount--;
                //increment start
                start++;
                    
            }
        }
        return end-start;
    }
}