class Solution {
    public int[] sortedSquares(int[] A) {
        int smallestPositiveIndex = 0;
        //find index of smallest positive integer
        while(smallestPositiveIndex < A.length && A[smallestPositiveIndex] < 0 ) smallestPositiveIndex++;
        
        int i = smallestPositiveIndex-1, j = smallestPositiveIndex, k = 0;
        int res[] = new int[A.length];

        //start two pointer from mid and mid-1, one reducing to 0 and another increasing to A.length
        while(i >= 0 && j < A.length)
        {
            if(A[i]*A[i] < A[j]*A[j]) 
            {
                res[k++] = A[i]*A[i];
                i--;
            }
            else
            {
                res[k++] = A[j]*A[j];
                j++;
            }
                
        }
        
        while(i >= 0){
            res[k++] = A[i]*A[i];
            i--;
        }
        while(j < A.length){
            res[k++] = A[j]*A[j];
            j++;
        }
        return res;
    }
}