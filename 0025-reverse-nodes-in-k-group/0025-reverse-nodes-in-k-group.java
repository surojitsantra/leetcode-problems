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
    public ListNode reverseKGroup(ListNode head, int k) {
        head = new ListNode(-1, head);
        ListNode prv = head, cur = head.next, tail = null;
        
        while(cur != null) {
            if(getLen(cur) < k) {
                prv.next = cur;
                break;
            }
            
            ListNode[] pointers = reverse(cur, k);
            ListNode first = pointers[0];
            ListNode second = pointers[1];
            
            prv.next = first;
            prv = cur;
            cur = second;
        }
        
        
        return head.next;
    }
    
    private int getLen(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    
    private ListNode[] reverse(ListNode node, int k) {
        ListNode prv = null, cur = node;
        
        for(int i = 1; cur != null && i <= k; i++) {
            ListNode nxt = cur.next;
            cur.next = prv;
            
            prv = cur;
            cur = nxt;
        }
        
        return new ListNode[]{prv, cur};
    }
    
}