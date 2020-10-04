class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //quue with where pair with smallest diff on the top
        PriorityQueue<int[]> qu = new PriorityQueue<>((a,b)->(a[0]+a[1]-b[0]-b[1]));
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        
        //push pair(all elemets nums1 with nums2[0]) ad length of nums2
        for(int i = 0; i < nums1.length && i < k; i++)
            qu.offer(new int[]{nums1[i], nums2[0], 0});
        
        while(k-- > 0 && !qu.isEmpty())
        {
            //get the first element and add it to result
            int[] cur = qu.poll();
            //add to result
            List<Integer> curRes = new ArrayList<>();
            curRes.add(cur[0]);
            curRes.add(cur[1]);
            res.add(curRes);
            
            
            if(cur[2] == nums2.length-1) continue;
            //add pair (cur[0], next element to nums2)
            qu.offer(new int[]{cur[0], nums2[cur[2]+1],cur[2]+1});
        }
        return res;
    }
}