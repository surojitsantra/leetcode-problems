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
    public ListNode partition(ListNode head, int x) {
        head = new ListNode(-101, head);
        
        ListNode p = head;
        
        while(p.next != null && p.next.val < x) p = p.next;
        if(p.next == null) return head.next;
        
        ListNode node = p;
        while(node.next != null) {
            if(node.next.val < x) {
                ListNode nextNode = node.next;
                node.next = nextNode.next;
                nextNode.next = p.next;
                p.next = nextNode;
                p = p.next;
            } else {
                node = node.next;
            }
        }
        
        return head.next;
    }
}