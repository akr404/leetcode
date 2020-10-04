/*
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.
*/

public String rearrangeString(String s, int k) {
    if(k==0) return s;
    int[] freq = new int[26];
    StringBuilder ans = new StringBuilder();

    //calculate frequency of each element
    for (char c : s.toCharArray()) freq[c - 'a']++;
    //create max pq
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
	//add  all chars to pq with their freq
    for(int i = 0; i < 26; i++) if(freq[i] > 0) pq.add(new int[]{i, freq[i]});
    Queue<int[]> q = new LinkedList<>();
    while (!pq.isEmpty()) {
    	// take element with largest freq
        int[] current = pq.poll();
        // add one count to answer and decrease it freq
        ans.append((char)(current[0] + 'a'));
        current[1]--;
        // add it to second que
        q.add(current);
        // if second que is greater than k, take element from front and add it to max heap queue
        if (q.size() >= k) { 
            int[] front = q.poll();
            if (front[1] > 0) pq.add(front);
        }
    }
    return ans.length() == s.length() ? ans.toString() : "";
} 