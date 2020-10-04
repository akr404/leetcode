class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S.length() == 0 && T.length() == 0) return false;
        return removeBackspace(S).equals(removeBackspace(T)); 
    }
    
    public String removeBackspace(String s)
    {
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray())
        {
            if(c == '#')
            {
                if(!st.isEmpty()) st.pop();
            }
            else
            {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        
        return sb.toString();
    }
}

//constant space with two pointer
//https://leetcode.com/problems/backspace-string-compare/solution/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}