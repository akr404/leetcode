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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>res = new ArrayList<List<Integer>>(); 
        List<Integer> cur = new ArrayList<>();
        sum(root,sum,cur, res);
        return res;
    }
    public void sum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res)   
    {
        if(root == null) return;
        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum)
        {
            res.add(new ArrayList(cur));
        }
        else
        {
            sum(root.left, sum-root.val, cur, res);
            sum(root.right, sum-root.val, cur, res);
        }
        cur.remove(cur.size()-1);
    }
}
