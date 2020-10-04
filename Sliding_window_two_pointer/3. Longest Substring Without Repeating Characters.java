class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, maxLen = 0;
        while(j < s.length())
        {
            if(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            else
            {
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, j-i);
            }
        }
        return maxLen;
    }
}