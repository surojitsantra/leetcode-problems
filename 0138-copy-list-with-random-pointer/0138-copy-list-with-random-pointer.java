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
        if(head == null) return head;
        
        crateDuplicateNodes(head);
        assignRandomPointersToDuplicateNodes(head);
        Node duplicateNodeHead = deAttachDuplicateNodes(head);
        return duplicateNodeHead;
    }
    
    private void crateDuplicateNodes(Node node) {
        while(node != null) {
            Node nextNode = node.next;
            node.next = new Node(node.val);
            node.next.next = nextNode;
            node = nextNode;
        }
    }
    
    private void assignRandomPointersToDuplicateNodes(Node node) {
        while(node != null) {
            Node randomNode = node.random;
            Node dplicateNode = node.next;
            if(randomNode == null) {
                dplicateNode.random = null;
            } else {
                dplicateNode.random = randomNode.next;
            }
            node = dplicateNode.next;
        }
    }
    
    private Node deAttachDuplicateNodes(Node node) {
        
        Node originalHead = node;
        Node originalTail = node;
        Node dummyHead = node.next;
        Node dummyTail = node.next;
        
        while(originalTail != null && dummyTail != null) {
            originalTail.next = dummyTail.next;
            originalTail = originalTail.next;
            
            if(originalTail != null) 
                dummyTail.next = originalTail.next;
            
            dummyTail = dummyTail.next;
        }
        return dummyHead;
    }
    
}