class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int[] edge: edges)
        {
            int parent1 = find(parent, edge[0]);
            int parent2 = find(parent, edge[1]);
            //node connected by edge to be union
            if(parent1 != parent2)
            {
                parent[parent1] = parent2;
                n--;
            }
        }
        return n;
    }
    
    public int find(int[] parent, int index)
    {
        while(parent[index] != index)
        {
            parent[index] = parent[parent[index]]; //path compression
            index = parent[index];
        }
        return index;
    }
}