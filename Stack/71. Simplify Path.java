class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        HashSet<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        
        for(String dir: path.split("/"))
        {
            if(dir.equals("..") && !st.empty()) st.pop();
            else
            {
                if(!skip.contains(dir))
                {
                    st.push(dir);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(String dir: st)
        {
            sb.append("/"+dir );
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}