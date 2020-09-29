class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] sorted = new int[numCourses];
        if(numCourses <= 0 ) return sorted;
        
        //init graph
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for(int i = 0; i< numCourses; i++)
        {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        //build graph
        for(int i = 0; i<prerequisites.length; i++)
        {
            int p = prerequisites[i][0], c = prerequisites[i][1];
            graph.get(p).add(c);
            inDegree.put(c, inDegree.get(c)+1);
        }
        
        //getAll vertices with 0
        Queue<Integer> q = new LinkedList<Integer>();
        for(Map.Entry<Integer, Integer> s: inDegree.entrySet())
        {
            if(s.getValue() == 0) q.add(s.getKey());
        }
        
        //topologicl sort
        int i = numCourses-1, k=0;
        while(!q.isEmpty())
        {
            int node  = q.poll();
            sorted[i--] = node;
            k++;
            for(int kid: graph.get(node))
            {
                inDegree.put(kid, inDegree.get(kid)-1);
                if(inDegree.get(kid) == 0)
                {
                    q.add(kid);
                }
            }
        }
        if (k != numCourses)
            return new int[0];
        return sorted;
        
    }
}