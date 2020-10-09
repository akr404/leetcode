/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

visited matrix for above input
1 1 2 
2 2 1 
3 4 2 
*/
class Solution {
    public static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
               int len = dfs(matrix, i, j,visited);
               max = Math.max(len, max);
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] visited)
    {
        if(visited[i][j] != 0) return visited[i][j];
        int max = 1;
        
        for(int[] dir:dirs)
        {
            int x = i+dir[0], y = j+dir[1];
            //if(next element is greater, not need to add to matrix)
            if(x < 0 || y < 0 || x>=matrix.length || y>=matrix[0].length || matrix[i][j] >= matrix[x][y]) continue;
            int len = dfs(matrix, x, y, visited)+1;
            max = Math.max(len, max);  
        }
        visited[i][j] = max;
        return max;
    }
}