class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int length = 0;
        // append at end, compare character with end character in sb
        // if match remove last char from sb
        for(char c: S.toCharArray())
        {
            if(length != 0 && c == sb.charAt(length-1))
                sb.deleteCharAt(length-- - 1);
            else
            {
                sb.append(c);
                length++;
            }
        }
        return sb.toString();
    }
}