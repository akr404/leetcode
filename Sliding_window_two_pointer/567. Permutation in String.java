public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        //s1 must be small
        if (s1.length() > s2.length())
            return false;
        //store count of chars in both strings
        for(int i = 0; i < s1.length(); i++){
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }
        //travers s2 with window s2.length-s1.length
        for(int i = 0; i < s2.length()-s1.length(); i++)
        {
            if(matches(s1map,s2map)) return true;
            //move the window
            s2map[s2.charAt(i+s1.length())-'a']++;
            s2map[s2.charAt(i)-'a']--;
            
        }
        return matches(s1map,s2map);
    }
    public boolean matches(int[] s1map, int[] s2map)
    {
        //check count
        for(int i = 0; i < 26; i++)
        {
            if(s1map[i] != s2map[i]) return false;
        }
        return true;
    }
}