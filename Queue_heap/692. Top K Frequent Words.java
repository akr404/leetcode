class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String word: words)
        {
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
           @Override
            public int compare(String s1, String s2)
            {
                if(hm.get(s1) == hm.get(s2)) return s1.compareTo(s2);
                else return hm.get(s2) - hm.get(s1);
            }
        });
        
        pq.addAll(hm.keySet());
        while(k > 0)
        {
            result.add(pq.poll());
            --k;
        }
        return result;
        
    }
}