/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> h = new HashMap<>();
        Node node = head;
        while(node!=null)
        {
            h.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node!=null)
        {
            h.get(node).next = h.get(node.next);
            h.get(node).random = h.get(node.random);
            node = node.next;
        }
        return h.get(head);
    }
}