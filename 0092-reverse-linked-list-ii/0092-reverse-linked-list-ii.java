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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right) return head;
        
        head = new ListNode(-501, head);
        
        ListNode firstPoint = head, lastPoint = head;
        
        for(int i = 1; i < left; i++) {
            firstPoint = firstPoint.next;
        }
        
        for(int i = 1; i <= right; i++) {
            lastPoint = lastPoint.next;
        }
        
        ListNode p = firstPoint.next;
        firstPoint.next = null;
        
        ListNode q = lastPoint;
        lastPoint = lastPoint.next;
        q.next = null;
        
        reverse(p);
        
        firstPoint.next = q;
        p.next = lastPoint;
        
        return head.next;
    }
    
    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        
        ListNode q = reverse(node.next);
        q.next = node;
        node.next = null;
        
        return node;
    }
}