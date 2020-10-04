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
 */
class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    TreeNode node;
    public BSTIterator(TreeNode root) {
        s = new Stack();
        node = root;
    }
    
    /** @return the next smallest number */
    public int next() {
      //go to leftest node, that will be smallest
       while(node!=null)
       {
           s.push(node);
           node = node.left;
       }
       node = s.pop();
       int res = node.val;
       //set cur node to right of left node (for next smallest)
       node = node.right;
       return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         return !s.isEmpty() || node != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */