class Node {
    public:
    int key, value;
    Node* prev;
    Node* next;
    
    Node(int key, int value) {
        this->key = key;
        this->value = value;
        this->prev = this->next = nullptr;
    }
};

class LRUCache {
private:
    int capacity;
    Node* head;
    unordered_map<int, Node*> nodeMap;
    
    Node* moveToHead(Node* head, Node* node) {
        if(node == head) return head;
        
        Node* lastNode = head->prev;
        if(node == lastNode) return lastNode;
        
        Node* prevNode = node->prev;
        Node* nextNode = node->next;
        
        prevNode->next = nextNode;
        nextNode->prev = prevNode;
        
        node->next = head;
        node->prev = lastNode;
        head->prev = node;
        lastNode->next = node;
        
        return node;
    }
    
    Node* overWriteNode(Node* head, Node* node, int key, int value) {
        node->key = key;
        node->value = value;
        return moveToHead(head, node);
    }
    
    Node* insertNewNode(Node* head, int key, int value) {
        Node* node = new Node(key, value);
        if(!head) {
            node->prev = node->next = node;
            return node;
        }
        
        Node* lastNode = head ->prev;
        
        node->next = head;
        node->prev = lastNode;
        head->prev = lastNode->next = node;
        
        return node;
    }
    
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        this->head = nullptr;
    }
    
    int get(int key) {
        if(nodeMap.find(key) == nodeMap.end()) return -1;
        Node* node = nodeMap[key];
        head = moveToHead(head, node);
        
        return node->value;
    }
    
    void put(int key, int value) {        
        if(nodeMap.find(key) != nodeMap.end()) {
            Node* node = nodeMap[key];
            head = overWriteNode(head, node, key, value);
        
        } else if(nodeMap.size() < capacity) {
            head = insertNewNode(head, key, value);
            nodeMap[key] = head;
        
        } else {
            Node* lastNode = head->prev;
            int lastNodeKey = lastNode->key;
            head = overWriteNode(head, lastNode, key, value);
            
            nodeMap.erase(lastNodeKey);
            nodeMap[key] = head;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */