class Solution {
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> index = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                st.push(i);
            else if(s.charAt(i) == ')')
            {
                //if stack is empty, add to invalid index
                if(st.isEmpty())
                {
                    index.add(i);
                }
                else
                    st.pop();
            }
            else
                continue;
        }
        // is stack not empty, add invalid indexes 
        while(!st.isEmpty())
            index.add(st.pop());
        
        StringBuilder sR = new StringBuilder();
        for(int i = 0 ; i<s.length(); i++)
        {
            //skip invalid indexes
            if(!index.contains(i))
                sR.append(s.charAt(i));
        }
        return sR.toString();
    }
}


//without stack
class Solution {

    public String minRemoveToMakeValid(String s) {

        // Parse 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            } if (c == ')') {
                // if already balanced, dont append to string
                if (balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        // after removing all closing braces, if open braces exist
        // Parse 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}