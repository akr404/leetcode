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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) return new TreeNode[]{null, null};
        else if(root.val <= V)
        {
            // The cut off is somewhere in the right subtree relative to root
            TreeNode[] cur = splitBST(root.right, V);
            root.right = cur[0];
            cur[0] = root;
            return cur;
        }
        else
        {
            TreeNode[] cur = splitBST(root.left, V);
            root.left = cur[1];
            cur[1] = root;
            return cur;
        }
    }
}