/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }
    
    public StringBuilder serial(StringBuilder s, TreeNode node)
    {
        // Append # at after leaves node
        if(node == null) return s.append("#");
        s.append(node.val).append(",");
        serial(s, node.left).append(",");
        //last one need not be concatenated with ,
        serial(s, node.right);
        return s;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    public TreeNode deserial(Queue<String> q)
    {
        String val = q.poll();
        if("#".equals(val)) return null;
        TreeNode node =  new TreeNode(Integer.valueOf(val));
        node.left = deserial(q);
        node.right = deserial(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));