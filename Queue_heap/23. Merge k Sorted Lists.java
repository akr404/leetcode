/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            new Comparator<ListNode>()
            {
                @Override
                public int compare(ListNode a, ListNode b) 
                { 
                    return a.val - b.val; 
                } 
            }
        );
        for(ListNode list: lists){
          if(list!=null)
              pq.add(list);  
        } 
        ListNode res = new ListNode(0);
        
        ListNode cur = res;
        while(!pq.isEmpty())
        {
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next!=null) 
                pq.add(cur.next);
        }
        return res.next;
    }
}