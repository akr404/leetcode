class Solution {
    public int[] intersect(HashSet<Integer> s1, HashSet<Integer> s2)
    {
        //if elements of smaller set, present in larger set
        int[] output = new int[s1.size()];
        int index = 0;
        for(int num: s1)
            if(s2.contains(num)) output[index++] = num;
        return Arrays.copyOf(output, index);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        //Add both arrays to set
        HashSet<Integer> s1 = new HashSet<>();
        for(int num: nums1) s1.add(num);
        HashSet<Integer> s2 = new HashSet<>();
        for(int num: nums2) s2.add(num);
        
        if(s1.size() > s2.size()) return intersect(s2, s1);
        else return intersect(s1,s2);
    }
}