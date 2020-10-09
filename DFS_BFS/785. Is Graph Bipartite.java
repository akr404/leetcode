class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) //
        {
            if(color[i] != 0) continue;
            Queue<Integer> qu = new LinkedList<>();
            qu.offer(i);
            color[i] = 1;
            while(!qu.isEmpty())
            {
                int node = qu.poll();
                for(int next: graph[node])
                {
                    if(color[next]!=0)
                    {
                        if(color[next] != -color[node]) return false;
                    }
                    else
                    {
                        color[next] = -color[node];
                        qu.offer(next);
                    }
                }
            }
        }
        return true;
    }
}