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
    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        ListNode node = head;
        ListNode prvNode = null;
        int carry = 0;
        
        while(node != null) {
            int sum = (node.val *2) +carry;
            node.val = (sum %10);
            carry = sum /10;
            prvNode = node;
            node = node.next;
        }
        
        if(carry > 0) {
            prvNode.next = new ListNode(carry);
        }
        
        return reverseList(head);
    }
    
    private ListNode reverseList(ListNode node) {
        ListNode prv = null;
        ListNode cur = null;
        ListNode nxt = node;
        
        while(nxt != null) {
            cur = nxt;
            nxt = nxt.next;
            cur.next = prv;
            prv = cur;
            
        }
        return prv;
    }
    
}