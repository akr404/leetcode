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
    int result;
    public int longest(TreeNode node)
    {
        if(node == null) return 0;
        int x = longest(node.left);
        int y = longest(node.right);
        result = Math.max(result, x+y);
        return Math.max(x,y)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        longest(root);
        return result;
    }
}