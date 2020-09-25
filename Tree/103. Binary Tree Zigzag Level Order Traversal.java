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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root == null) return res;
        q.offer(root);
        boolean zigzag = false;
        while(!q.isEmpty())
        {
            int t = q.size();
            List<Integer> curVals = new ArrayList<>();
            for(int i = 0; i < t; i++)
            {
                TreeNode node = q.poll();
                if(!zigzag) curVals.add(node.val);
                else curVals.add(0,node.val);
                
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                
                
            }
            zigzag = !zigzag;
            res.add(curVals);
        }
        return res;
    }
}
