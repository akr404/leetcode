//Bucket sort O(n)

class Solution {
    public List<Integer>  topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqmap = new HashMap<>();
        
        //update the frequency
        for(int num: nums)
            freqmap.put(num, freqmap.getOrDefault(num, 0)+1);

        // we can also apply quick select here with O(n) - Kth largest element
        //Create the bucket to store (index: frequency, elements at index: repeating element)
        // most frequenct element comes at the end index in bucket
        //some buckets will be emtpy
        List<Integer>[] bucket = new List[nums.length+1];
        
        for(int key: freqmap.keySet())
        {
            int freq = freqmap.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        //last non empty bucket is most frequent, kth frequent kth non empty bucket from end
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length-1; i > k ; i++)
        {
            if(bucket[i]!= null)
                res.addAll(bucket[i]);
        }
        return res.toArray(new int[res.size()]);
    }
}


// a