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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = root;
        List<List<Integer>> result = new ArrayList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            List<Integer> x = new ArrayList<>();
            Integer size = q.size();
            for(int i = 0; i<size; i++)
            {
                TreeNode n = q.remove();
                if(n!=null)
                {
                    x.add(n.val);
                    q.add(n.left);
                    q.add(n.right);
               
                }
            }
            if(x.size() > 0) result.add(0,x);        
        }
        
        return result;
    }
}