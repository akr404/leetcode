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
    int max = 0;
    TreeNode lca;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        deepest(root, 0);
        return lca;
    }
    public int deepest(TreeNode root, int hight)
    {
        max = Math.max(hight, max);
        if(root == null) return hight;
        
        int left = deepest(root.left, hight+1);
        int right = deepest(root.right, hight+1);
        if(left == max && right == max)
            lca = root;
        return Math.max(left, right);
    }
}
