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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        //discard right tree if root value is greater than high
        if (root.val > high) return trimBST(root.left, low, high);

        //discard left if root val is less than low
        if (root.val < low) return trimBST(root.right, low, high);

        //repeat for other nodes
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;   
    }
}