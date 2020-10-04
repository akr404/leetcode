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
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p2!=null && p2.next!=null)
        {
            p1 = p1.next;
            p2=p2.next.next;
        }
        p1 = reverse(p1);
        p2 = head;
        
        while(p1!=null)
        {
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2= p2.next;
            
        }
        return true;
    
        
    }
    
     public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
   
}