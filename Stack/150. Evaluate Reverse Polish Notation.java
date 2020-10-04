class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        int result = 0;
        for(String s: tokens)
        {
            // if encounter and operator then pop two from stack, evaluate and pushback
            if(s.equals("+"))
            {
                st.add(st.pop()+st.pop());
                
            }
            else if(s.equals("-"))
            {
                int b = st.pop();
                int a = st.pop();
                st.add(a-b);
            }
            else if(s.equals("*"))
            {
                 st.add(st.pop()*st.pop());
            }
            else if(s.equals("/"))
            {
                int b = st.pop();
                int a = st.pop();
                st.add(a/b);
            }
            else
            {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}