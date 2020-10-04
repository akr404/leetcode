class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, maxLength = 0;
        int[] count = new int[128];
        //window end-start
        for(int end = 0 ;end < s.length(); end++)
        {
            //count character occuring most number of times
            maxLength = Math.max(maxLength, ++count[s.charAt(end)]);

            //current window >= character repeating most umber of time + k(changing other character) 
            //remove first characte and decreament the count
            if(maxLength+k<= end-start)
                count[s.charAt(start++)]--;
            
        }
        return s.length()-start;
    }
}