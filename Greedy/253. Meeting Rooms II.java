//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
//find the minimum number of conference rooms required.
//O(nlogn)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++)
        {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0, j = 0;
        for(int i = 0; i < intervals.length; i++)
        {
            if(start[i] < end[j])
            {
                count++;
            }
            else
            {
                j++;
            }
        }
        return count;
    }
}

//252. Meeting Rooms

class Solution {

  public boolean canAttendMeetings(int[][] intervals) {
    //sort according to start time
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
      }
    });
    //check of end time > starttime of next meeting
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0])
        return false;
    }
    return true;
  }
}