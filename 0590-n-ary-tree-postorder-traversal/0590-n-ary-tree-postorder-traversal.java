/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> postorderElements = new ArrayList<>();
        
        postorderTraversal(root, postorderElements);
        
        return postorderElements;
    }
    
    private void postorderTraversal(Node node, List<Integer> postorderElements) {
        if(node == null) return;
        
        for(Node child :node.children) {
            postorderTraversal(child, postorderElements);
        }
        postorderElements.add(node.val);
    }
    
}