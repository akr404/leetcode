/*
DFS
Time complexity : O(n^2)O(n 
2
 ). The complete matrix of size n^2n 
2
  is traversed.

Space complexity : O(n)O(n). A queuequeue and visitedvisited array of size nn is used.
*/
class Solution {
      void dfs(int[][] M, int[] visited, int i) {
            for(int j = 0; j< M.length; j++)
            {
                if(visited[j] == 0 && M[i][j] == 1)
                {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
      }
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
          return 0;
        }
        int[] visited = new int[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++)
        {
            if(visited[i] == 0)
            {
                count++;
                dfs(M, visited, i);
            }
        }

        return count;
    }
}


/*
BFS
Time complexity : O(n^2)O(n 
2
 ). The complete matrix of size n^2n 
2
  is traversed.

Space complexity : O(n)O(n). A queuequeue and visitedvisited array of size nn is used.
*/
public class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}