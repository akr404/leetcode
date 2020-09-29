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