/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }
    
    private Node clone(Node node, Map<Integer, Node> graphMap) {
        if(node == null) return null;
        
        Node clonedNode = new Node(node.val);
        graphMap.put(clonedNode.val, clonedNode);
        
        for(Node neighbor :node.neighbors) {
            if(graphMap.containsKey(neighbor.val)) {
                clonedNode.neighbors.add(graphMap.get(neighbor.val));
            } else {
                clonedNode.neighbors.add(clone(neighbor, graphMap));
            }
        }
        
        return clonedNode;
    }
    
}