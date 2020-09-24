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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) return paths;
        
        dfsPath(root,"", paths);
        return paths;
    }
    public void dfsPath(TreeNode node,String path, List<String> paths)
    {
        if(node!=null)
        {
            path += Integer.toString(node.val);
            if(node.left == null && node.right == null)
            {
                paths.add(path);
            }
            else
            {
                path += "->";
                dfsPath(node.left, path, paths);
                dfsPath(node.right, path, paths);
            }
        }
        
    }
}