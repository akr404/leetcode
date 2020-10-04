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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        
        //while stack is not empty  or root is not null
        while(root != null || !s.isEmpty())
        {
            // push root and all its left nodes
            while(root!=null)
            {
                s.push(root);
                root = root.left;
            }
            //pop last left node in stack
            root = s.pop();
            //add its value
            res.add(root.val);
            //go to right and add right node
            root = root.right;
        }
        return res;
    }
}