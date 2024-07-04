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
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode point = result;
        
        int sum = 0;
        ListNode node = head.next;
        
        while(node != null) {
            if(node.val == 0) {
                point.next = new ListNode(sum);
                sum = 0;
                point = point.next;
            } else {
                sum += node.val;
            }
            node = node.next;
        }
        
        return result.next;
    }
}