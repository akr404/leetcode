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
 Use BFS to do a level order traversal,
add childrens to the bfs queue,
until we met the first empty node.

For a complete binary tree,
there should not be any node after we met an empty one.

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