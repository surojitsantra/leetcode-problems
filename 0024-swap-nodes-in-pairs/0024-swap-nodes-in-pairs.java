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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1, head);
        
        ListNode prv = dummy;
        ListNode cur = head;
        
        while(cur != null && cur.next != null) {
            prv.next = cur.next;
            cur.next = cur.next.next;
            prv.next.next = cur;
            
            prv = cur;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}