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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, set, k);
    }
    public boolean find(TreeNode root, Set<Integer> set, int k)
    {
        if(root == null) return false;
        if(set.contains(k-root.val) ) return true;
        set.add(root.val);
        return find(root.left, set, k) ||find(root.right, set, k);
    }
}