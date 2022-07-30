/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    public void helper(Node root) {
        if (root == null || root.left == null || root.right == null) {
        
        } else {
            root.left.next = root.right;
            
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            
            helper(root.left);
            helper(root.right);
        }
    }
    
    
}