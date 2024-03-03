/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getLength(head);
        
        head = new ListNode(-1, head);
        int jumpsReq = size -n;
        
        ListNode node = head;
        for(int i = 1; i <= jumpsReq; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        
        return head.next;
    }
    
    
    private int getLength(ListNode node) {
        int len = 0;
        
        while(node != null) {
            len++;
            node = node.next;
        }
        
        return len;
    }
}