class Solution {
    public String removeDuplicates(String s, int k) {
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();
            
        for(char c : s.toCharArray()) {
            sb.append(c);
            int last = sb.length()-1;
            
            //store count(adjecent duplicate) 
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last-1) ? count[last-1] : 0);
            // remove last k duplicate character
            if(count[last] >= k) sb.delete(sb.length()-k, sb.length());
            
           
        }
        return sb.toString();
    }
    
}