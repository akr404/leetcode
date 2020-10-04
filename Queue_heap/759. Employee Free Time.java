/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Interval> meetings = new ArrayList<>();
        
        schedule.forEach(e -> meetings.addAll(e));
        Collections.sort(meetings, (a,b)->a.start-b.start);
        
        //add first element from sorted array
        Interval temp = meetings.get(0);
        for(Interval cur: meetings)
        {
            // if previous elements end time is less than next elements start time(means GAP)
            if(temp.end < cur.start)
            {
                result.add(new Interval(temp.end, cur.start));
                // move to next
                temp = cur;
            }
            else
            {
                // next becomes the one with greater end time
                temp = temp.end < cur.end? cur: temp;
            }
        }
        return result;
    }
}