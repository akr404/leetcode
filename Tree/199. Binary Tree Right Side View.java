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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        qu.offer(root);
        while(!qu.isEmpty())
        {
            int size = qu.size();
            for(int t = 0; t < size; t++)
            {
                if(t == 0) res.add(qu.peek().val);
                TreeNode node = qu.poll();
                
                if(node.right != null)   qu.offer(node.right);
                if(node.left != null)    qu.offer(node.left);
                
                
            }
        }
        return res;
    }
}