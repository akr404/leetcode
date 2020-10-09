class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        char[] braces = new char[]{'(', ')'};
        depathFirstSearch(s, result, braces, 0, 0);
        return result;
    }

    public static void depathFirstSearch(String s, List<String> result, char[] braces, int low, int high) {
        int count = 0;
        int i = low;
        while (i < s.length() && count>= 0) {

            if (s.charAt(i) == braces[0]) count ++;
            if (s.charAt(i) == braces[1]) count --;
            i ++;
        }

        if (count >= 0)  {
            // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
            String reversed = new StringBuffer(s).reverse().toString();
            if (braces[0] == '(') depathFirstSearch(reversed, result, new char[]{')', '('}, 0, 0);
            else result.add(reversed);

        }

        else {  // extra ')' is detected and we have to do something
            i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
            for (int j = high; j<= i; j++) {
                if (s.charAt(j) == braces[1] && (j == high || s.charAt(j-1) != braces[1])) {
                    depathFirstSearch(s.substring(0, j) + s.substring(j+1, s.length()), result, braces, i, j);
                }
            }
        }
    }
}