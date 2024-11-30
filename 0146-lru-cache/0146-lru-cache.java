class Node {
    public int key, value;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
}

class LRUCache {

    private List<Node> head;
    private int capacity;
    private int size;
    private Map<Integer, Node> keyVsNode;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.head = new LinkedList<>();
        this.capacity = capacity;
        this.keyVsNode = new HashMap<>();
    }
    
    public int get(int key) {
        if(keyVsNode.containsKey(key)) {
            Node node = keyVsNode.get(key);
            moveToFront(node);
            
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyVsNode.containsKey(key)) {
            //update node
            Node node = keyVsNode.get(key);
            node.value = value;
            
            moveToFront(node);
        } else {
            if(size >= capacity) {
                //delete node
                
                keyVsNode.remove(head.getLast().key);
                head.removeLast();
                size--;
            }
            Node node = new Node(key, value);
            
            keyVsNode.put(key, node);
            head.addFirst(node);
            size++;
        }
    }
    
    private void moveToFront(Node node) {
        if(head.getFirst() != node) {
            head.remove(node);
            head.addFirst(node);
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */