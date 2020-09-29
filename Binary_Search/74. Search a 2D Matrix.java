class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low <= high)
        {
            int pivot = (high+low)/2;
            
            //row = pivot/n, col = pivot%n
            int midEle = matrix[pivot/n][pivot%n];
            if(midEle == target) return true;
            else if(target < midEle) 
                high = pivot-1;
            else
                low = pivot+1;
        }
        return false;
    }
}