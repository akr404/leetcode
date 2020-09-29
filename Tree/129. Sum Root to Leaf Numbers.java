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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return sum;
    }
    public void preorder(TreeNode node, int curSum)
    {
        if(node!=null)
        {
            curSum = curSum*10 + node.val;
            if(node.left == null && node.right == null)
            {
                sum += curSum;
            }
            
            preorder(node.left, curSum);
            preorder(node.right, curSum);
        }
    }
}


class Solution {
  public int sumNumbers(TreeNode root) {
    int rootToLeaf = 0, currNumber = 0;
    Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
    stack.push(new Pair(root, 0));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> p = stack.pop();
      root = p.getKey();
      currNumber = p.getValue();

      if (root != null) {
        currNumber = currNumber * 10 + root.val;
        // if it's a leaf, update root-to-leaf sum
        if (root.left == null && root.right == null) {
          rootToLeaf += currNumber;
        } else {
          stack.push(new Pair(root.right, currNumber));
          stack.push(new Pair(root.left, currNumber));
        }
      }
    }
    return rootToLeaf;
  }
}