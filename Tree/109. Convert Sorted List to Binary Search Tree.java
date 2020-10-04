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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

Nlog(n)
Space ;ogn
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }
    
    public TreeNode toBST(ListNode head, ListNode tail)
    {
        if(head == tail) return null;
        // find middle node
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode bst = new TreeNode(slow.val);
        bst.left = toBST(head, slow);
        bst.right = toBST(slow.next, tail);
        return bst;
    }
}

/*
*
*/

/**
Time Complexity: The time complexity is still O(N)O(N) 
since we still have to process each of the nodes in the linked list once and form corresponding BST nodes.
Space Complexity: O(\log N)O(logN) since now the only extra space is used by the recursion stack 
and since we are building a height balanced BST, the height is bounded by \log NlogN.
 */
class Solution {

  private ListNode head;

  private int findSize(ListNode head) {
    ListNode ptr = head;
    int c = 0;
    while (ptr != null) {
      ptr = ptr.next;  
      c += 1;
    }
    return c;
  }

  private TreeNode convertListToBST(int l, int r) {
    // Invalid case
    if (l > r) {
      return null;
    }

    int mid = (l + r) / 2;

    // First step of simulated inorder traversal. Recursively form
    // the left half
    TreeNode left = this.convertListToBST(l, mid - 1);

    // Once left half is traversed, process the current node
    TreeNode node = new TreeNode(this.head.val);
    node.left = left;

    // Maintain the invariance mentioned in the algorithm
    this.head = this.head.next;

    // Recurse on the right hand side and form BST out of them
    node.right = this.convertListToBST(mid + 1, r);
    return node;
  }

  public TreeNode sortedListToBST(ListNode head) {
    // Get the size of the linked list first
    int size = this.findSize(head);

    this.head = head;

    // Form the BST now that we know the size
    return convertListToBST(0, size - 1);
  }
}