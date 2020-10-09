class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return isValid(s, start+1, end) || isValid(s, start, end-1);
            }
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
    public boolean isValid(String s, int i, int j) {
        while(i  < j)
        {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}