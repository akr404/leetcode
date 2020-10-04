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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list = new ListNode(0);
        ListNode p1 = list;
        ListNode p2 = list;
        p1.next = head;
        p2.next = head;
        for(int i = 0; i<=n ; i++)
            p2 = p2.next;
        while(p2!=null)
        {
            p1 = p1.next;
            p2=p2.next;
        }
        p1.next = p1.next.next;
        return list.next;
    }
}