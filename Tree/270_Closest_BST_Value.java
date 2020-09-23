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
    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        int closest = root.val, val;
        while(node != null)
        {
            val = node.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            if(target < node.val) node = node.left;
            else node=node.right;
        }
        return closest;
    }
    
}