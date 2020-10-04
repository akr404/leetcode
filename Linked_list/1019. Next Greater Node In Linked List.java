/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        List<Integer> a = new ArrayList<>();
        
        while(p!=null)
        {
            a.add(p.val);
            p=p.next;
        }
        int[] res = new int[a.size()]; 
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<a.size(); ++i)
        {
            while(!s.isEmpty() && a.get(i) > a.get(s.peek()))
                res[s.pop()] = a.get(i);
            s.add(i);
        }
        return res;
    }
}