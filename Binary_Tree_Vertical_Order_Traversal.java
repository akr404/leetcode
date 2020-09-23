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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        //Store the list of columns and indexs(-n....0(root)...+n)
        HashMap<Integer, ArrayList<Integer>> colList= new HashMap<>();
        //traverse with value of columns
        Queue<Pair<TreeNode, Integer>> qu = new LinkedList<>();
        //store results
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        int column = 0;
        qu.add(new Pair(root, column));
        int minCol = 0 , maxCol = 0;
        
        while(!qu.isEmpty())
        {
            
            Pair<TreeNode, Integer> pair = qu.poll();
            TreeNode node = pair.getKey();
            column = pair.getValue();
            
            if(node!=null)
            {
                if(!colList.containsKey(column))
                {
                    colList.put(column, new ArrayList<Integer>());
                }
                colList.get(column).add(node.val);
                
                //calculate max and min(for traversal to print)
                minCol = Math.min(minCol, column);
                maxCol = Math.max(maxCol, column);

                //add columns
                qu.add(new Pair(node.left, column-1));
                qu.add(new Pair(node.right, column+1));
            }
            
        }
        
        for(int i = minCol; i <= maxCol; i++)
        {
            res.add(colList.get(i));
        }
        return res;
        
    }
}