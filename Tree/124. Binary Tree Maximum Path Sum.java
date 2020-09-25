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
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
    public int max_gain(TreeNode node)
    {
        if(node == null) return 0;
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);
        
        //take both left and right paths into consideration
        int new_max = left_gain+right_gain+node.val;
        //update max
        max_sum = Math.max(max_sum, new_max);
        
        //if not considering both left and right paths, return just one with max value
        return node.val+Math.max(left_gain, right_gain);
    }
}