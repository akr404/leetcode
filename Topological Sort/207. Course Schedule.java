class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sorted = new ArrayList<Integer>();
        if(numCourses <= 0) return false;
        
        //initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< numCourses; i++)
        {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        
        //build the graph
        for(int i=0; i<prerequisites.length; i++)
        {
            int parent = prerequisites[i][0]; int child =prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }
        
        //Find all source vertices, push them in queue
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) 
        {
          if (entry.getValue() == 0)
            sources.add(entry.getKey());
        }
        //topological sort
        while(!sources.isEmpty())
        {
            int node = sources.poll();
            sorted.add(node);
            List<Integer> children = graph.get(node);
            for(int kid: children)
            {
                inDegree.put(kid, inDegree.get(kid)-1);
                if(inDegree.get(kid) == 0)
                    sources.add(kid);
            }
        }
        return sorted.size() == numCourses;
    }
}