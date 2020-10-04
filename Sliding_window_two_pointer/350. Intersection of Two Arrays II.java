class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        if(num1.length > num2.length)
            return intersect(num2, num1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        //add counts of num occurance in num1
        for(int num: num1)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        int k = 0;
        //if count greater than 0 in hashmap, reduce count and add element to rsult
        //store result in num1 itself(we have already processed num1)
        for(int num: num2)
        {
            if(map.getOrDefault(num, 0) > 0)
            {
                num1[k++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        return Arrays.copyOfRange(num1, 0, k);
    }
}

/*
Time Complexity: \mathcal{O}(n\log{n} + m\log{m})O(nlogn+mlogm), where nn and mm are the lengths of the arrays. We sort two arrays independently, and then do a linear scan.

Space Complexity: from \mathcal{O}(\log{n} + \log{m})O(logn+logm) to \mathcal{O}(n + m)O(n+m), depending on the implementation of the sorting algorithm. For the complexity analysis purposes, we ignore the memory required by inputs and outputs.


*/

public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            ++i;
        } else if (nums1[i] > nums2[j]) {
            ++j;
        } else {
            nums1[k++] = nums1[i++];
            ++j;
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}