
/*
 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
*/


class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new  Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            // process if get ], push if get [
            if(s.charAt(i) == ']')
            {
                StringBuilder sb = new StringBuilder("");
                // remove all characters till encound opening braces
                while(st.peek() != '[')
                {
                    sb.append(st.pop());
                }
                
                // after opening braces, encounter k (which could be n digit number)
                //pop opening braces
                st.pop();
                
                //get k
                int k = 0;
                int base = 1;
                while(!st.isEmpty() && Character.isDigit(st.peek()))
                {
                    k += (st.pop() - '0') * base;
                    base = base *10;
                }
                while(k != 0)
                {
                    //push back into stack inr everse order
                    for(int j = sb.length()-1; j >= 0; j--)
                    {
                        st.push(sb.charAt(j));
                    }
                    
                    k--;
                }
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        
        //result
        StringBuilder res = new StringBuilder("");
        while(!st.isEmpty())
            res.append(st.pop());
        return res.reverse().toString();
    }
}