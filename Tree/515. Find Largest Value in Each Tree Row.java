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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int t = q.size();
            int maxVal = Integer.MIN_VALUE;
            for(int i = 0; i < t; i++)
            {
                TreeNode node = q.poll();
                maxVal = Math.max(maxVal, node.val);
                if(node.left!= null ) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(maxVal);
        }
        return res;
    }
}