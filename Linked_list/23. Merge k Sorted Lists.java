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
    public ListNode mergeKLists(ListNode[] lists) {
        int interval =1;
        if(lists.length == 0) return null;
        while(interval < lists.length)
        {
            for(int i = 0; i+interval < lists.length; i = i + interval*2 )
            {
                lists[i] = mergeList(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }
            else
            {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
                
            }
        }
        if(l1 != null)
        {
            l3.next = l1;
        }
        if(l2 != null)
        {
            l3.next = l2;
        }
        return result.next;
    }
}