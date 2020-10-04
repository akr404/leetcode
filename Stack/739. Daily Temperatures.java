class Solution {
    public int[] dailyTemperatures(int[] T) {
     int[] res = new int[T.length]; 
    Stack<Integer> s = new Stack<>();
    for(int i = 0; i<T.length; ++i)
    {
        while(!s.isEmpty() && T[i] > T[s.peek()])
        {
            int j = s.pop();
            res[j] = i-j;
        }
        s.push(i);
    }
    return res;
    }
}