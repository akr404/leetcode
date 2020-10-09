class Solution {
    public int shortestBridge(int[][] A) {
        if(A.length == 0) return 0;
        int m = A.length;
        int n = A[0].length;
        Queue<int[]> que = new LinkedList<>();
        boolean found = false;
        
        //find one island and change all values to 2
        for(int i = 0; i < m ; i++)
        {
            if(found) break;
            for(int j = 0; j < n ; j++)
            {
                if(A[i][j] == 1)
                {
                    dfs(A, i, j, que);
                    //found the island
                    found = true;
                    break;
                }
            }
        }
        //BFS over found island to till find second island
        // mark all the zero nodes as 2
        // all nodes of second island will stilll have 1
        // if find 1(found second island) return result
        int steps = 0;
        while(!que.isEmpty())
        {
            int t = que.size();
            for(int i = 0; i < t; i++)
            {
                int[] node = que.poll();
                int x = node[0];
                int y = node[1];
                if(x > 0 && A[x-1][y] == 0)
                {
                    A[x-1][y] = 2;
                    que.offer(new int[]{x-1, y});
                }
                if(y > 0 && A[x][y-1] == 0)
                {
                    A[x][y-1] = 2;
                    que.offer(new int[]{x, y-1});
                }
                if(x < m-1 && A[x+1][y] == 0)
                {
                    A[x+1][y] = 2;
                    que.offer(new int[]{x+1, y});
                }
                if(y < n-1 && A[x][y+1] == 0)
                {
                    A[x][y+1] = 2;
                    que.offer(new int[]{x, y+1});
                }
                
                // once we find the second island, return current bridge value
                if((x > 0 && A[x-1][y] == 1)
                   || (y > 0 && A[x][y-1] == 1) 
                   || (x < m-1 && A[x+1][y] == 1)
                   || (y < n-1 && A[x][y+1] == 1))
                {
                    return steps;
                }
            }
            steps++;
        }
        return steps;
        
    }
    
    public void dfs(int[][] grid, int i, int j, Queue<int[]> que)
    {
        if(i<0 || i >= grid.length || j <0 || j >= grid[0].length || grid[i][j] != 1) return;
        
        grid[i][j] = 2;
        que.offer(new int[]{i,j});
        dfs(grid, i+1, j, que);
        dfs(grid, i, j+1, que);
        dfs(grid, i-1, j, que);
        dfs(grid, i, j-1, que);
    }
}