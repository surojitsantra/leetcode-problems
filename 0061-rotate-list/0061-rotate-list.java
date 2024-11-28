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
    public ListNode rotateRight(ListNode head, int k) {
        int totalLen = getLength(head);
        if(totalLen == 0) return head;
        k = k %totalLen;
        if(k == 0) return head;
        
        ListNode node = head;
        int i = 1;
        while(i < (totalLen -k)) {
            node = node.next;
            i++;
        }
        
        ListNode head2 = node.next;
        node.next = null;
        
        node = head2;
        while(node.next != null) node = node.next;
        
        node.next = head;
        return head2;
    }
    
    private int getLength(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    
}