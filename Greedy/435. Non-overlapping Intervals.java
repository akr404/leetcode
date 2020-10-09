
/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

*/public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length== 0) return 0;
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        int end =0, count =1, n = intervals.length;
        for(int i =1; i < n ; i++){
            //remove if start > end of next
            if (intervals[i][0] >= intervals[end][1]){
                end = i;
                count++;
            }
        }
        return n-count;
    }