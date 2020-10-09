class Solution {
    
    final int[][] dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        int[][]  canReach = new int[m][n];
        int numBuilding = 0;
        Queue<int[]> que = new LinkedList<int[]>();
        
        for(int i = 0 ; i<m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    //for each zero, how much distance is it from the building
                    que.offer(new int[]{i, j});
                    bfs(que, grid, sum, canReach, m, n);
                    // count buildings as well
                    numBuilding++;
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for(int i = 0 ; i<m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //find min in sum matrix, if its a 0 and can reach all the buildings
                if(grid[i][j] == 0  && canReach[i][j] == numBuilding)
                    minDist = Math.min(minDist, sum[i][j]);
            }
        }
        
        return minDist == Integer.MAX_VALUE? -1: minDist;
    }
    
    public void bfs(Queue<int[]> que, int[][] grid, int[][] sum, int[][] canReach ,int m ,int  n)
    {
        int jump  = 1;
        boolean isVisited[][] = new boolean[m][n];
        while(!que.isEmpty())
        {
            int t = que.size();
            for(int i = 0; i < t ; i++)
            {
                int[] index = que.poll();
                int x = index[0];
                int y = index[1];
                for(int[] dir: dirs)
                {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if(dx < 0 || dy < 0 || dx > m-1 || dy > n-1 || grid[dx][dy] != 0 || isVisited[dx][dy]) continue;
                    que.offer(new int[]{dx,dy});
                    isVisited[dx][dy] = true;
                    sum[dx][dy] += jump;
                    canReach[dx][dy]++;
                }
            }
            
            jump++;
        }
    }
}