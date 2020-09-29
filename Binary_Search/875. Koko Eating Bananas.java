class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1 , r = 1000000000;
        while(l < r)
        {
            //find a mid(eating spead)
            int mid = (l+r)/2, total = 0;

            for(int pile: piles)
                //divide all element by mid(total hours)
                total += (pile+mid-1)/mid;
            //if greater then increase mid
            if(total > H) l = mid +1;
            //if less than decrease mid
            else r = mid;
        }
        return l;
    }
}

