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
    public ListNode removeNodes(ListNode head) {
        
        head = reverseList(head);
        head = new ListNode(1, head);
        ListNode curNode = head;
        ListNode nxtNode = curNode.next;
        
        while(nxtNode != null) {
            if(curNode.val > nxtNode.val) {
                curNode.next = nxtNode.next;
                nxtNode = nxtNode.next;
            } else {
                curNode = curNode.next;
                nxtNode = nxtNode.next;
            }
        }
        
        head = head.next;
        head = reverseList(head);
        
        return head;
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