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
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prv = head;
        ListNode cur = head.next;
        
        while(cur != null) {
            int a = prv.val;
            int b = cur.val;
            ListNode node = new ListNode(gcd(a, b));
            
            prv.next = node;
            node.next = cur;
            
            prv = cur;
            cur = cur.next;
            
        }
        
        return head;
    }
}