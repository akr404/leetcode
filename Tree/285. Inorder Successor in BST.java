/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ret = null;
        while (root != null) {
            // 1. current root is smaller or equal, definitely not in this branch
            if (root.val <= p.val) {
                root = root.right;
            // 2. current root is bigger, definitely in this branch             
            } else {
                // 2.1 root is 1 of the successors, although might not be the one
                ret = root;
                // 2.2 maybe we can find a closer successor in the left branch
                root = root.left;
            }
        }
        return ret;
    }
}