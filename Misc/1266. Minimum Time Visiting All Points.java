
/*
Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds
*/
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time  = 0;
        for(int i = 1; i < points.length; i++)
        {
            int[] cur = points[i], prev = points[i-1];
            //minimu time will if max distance travelled in one second in x or y direction
            time += Math.max(Math.abs(cur[0]-prev[0]),Math.abs(cur[1]-prev[1]));
        }
        return time;
    }
}