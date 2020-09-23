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
/*
* Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
*/
class Solution {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return ans;
    }
    
    public void dfs(TreeNode root, int L, int R)
    {
        if(root != null)
        {
            if(root.val >= L && root.val <= R) ans += root.val;
            if(L < root.val) dfs(root.left, L, R);
            if(R > root.val) dfs(root.right, L, R);
        }
    }
}