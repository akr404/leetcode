class Solution {
    public int findMin(int[] num) {
      int start=0,end=num.length-1;

            while (start<end) {
                int mid = (start+end)/2;

                if (num[mid]>num[end]) 
                {
                    start = mid+1;
                } 
                else if(num[mid]<num[end])
                {
                    end = mid;
                }
                /*In this case, we are not sure which side of the pivot that the desired minimum element would reside.
                To further reduce the search scope, a safe measure would be to reduce the upper bound by one (i.e. high = high - 1),
                rather than moving aggressively to the pivot point.
                The above strategy would prevent the algorithm from stagnating (i.e. endless loop). 
                More importantly, it maintains the correctness of the procedure, i.e. we would not end up with skipping the desired element.
                */
                else
                    end -= 1;
            }

            return num[start];
    }
}

