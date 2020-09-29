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
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while(bfs.peek() != null)
        {
            TreeNode node = bfs.poll();
            if(node!=null)
            {
                bfs.offer(node.left);
                bfs.offer(node.right);
            }
        }
        
        while(bfs.peek() == null && !bfs.isEmpty())
            bfs.poll();
        return bfs.isEmpty();
    }
}