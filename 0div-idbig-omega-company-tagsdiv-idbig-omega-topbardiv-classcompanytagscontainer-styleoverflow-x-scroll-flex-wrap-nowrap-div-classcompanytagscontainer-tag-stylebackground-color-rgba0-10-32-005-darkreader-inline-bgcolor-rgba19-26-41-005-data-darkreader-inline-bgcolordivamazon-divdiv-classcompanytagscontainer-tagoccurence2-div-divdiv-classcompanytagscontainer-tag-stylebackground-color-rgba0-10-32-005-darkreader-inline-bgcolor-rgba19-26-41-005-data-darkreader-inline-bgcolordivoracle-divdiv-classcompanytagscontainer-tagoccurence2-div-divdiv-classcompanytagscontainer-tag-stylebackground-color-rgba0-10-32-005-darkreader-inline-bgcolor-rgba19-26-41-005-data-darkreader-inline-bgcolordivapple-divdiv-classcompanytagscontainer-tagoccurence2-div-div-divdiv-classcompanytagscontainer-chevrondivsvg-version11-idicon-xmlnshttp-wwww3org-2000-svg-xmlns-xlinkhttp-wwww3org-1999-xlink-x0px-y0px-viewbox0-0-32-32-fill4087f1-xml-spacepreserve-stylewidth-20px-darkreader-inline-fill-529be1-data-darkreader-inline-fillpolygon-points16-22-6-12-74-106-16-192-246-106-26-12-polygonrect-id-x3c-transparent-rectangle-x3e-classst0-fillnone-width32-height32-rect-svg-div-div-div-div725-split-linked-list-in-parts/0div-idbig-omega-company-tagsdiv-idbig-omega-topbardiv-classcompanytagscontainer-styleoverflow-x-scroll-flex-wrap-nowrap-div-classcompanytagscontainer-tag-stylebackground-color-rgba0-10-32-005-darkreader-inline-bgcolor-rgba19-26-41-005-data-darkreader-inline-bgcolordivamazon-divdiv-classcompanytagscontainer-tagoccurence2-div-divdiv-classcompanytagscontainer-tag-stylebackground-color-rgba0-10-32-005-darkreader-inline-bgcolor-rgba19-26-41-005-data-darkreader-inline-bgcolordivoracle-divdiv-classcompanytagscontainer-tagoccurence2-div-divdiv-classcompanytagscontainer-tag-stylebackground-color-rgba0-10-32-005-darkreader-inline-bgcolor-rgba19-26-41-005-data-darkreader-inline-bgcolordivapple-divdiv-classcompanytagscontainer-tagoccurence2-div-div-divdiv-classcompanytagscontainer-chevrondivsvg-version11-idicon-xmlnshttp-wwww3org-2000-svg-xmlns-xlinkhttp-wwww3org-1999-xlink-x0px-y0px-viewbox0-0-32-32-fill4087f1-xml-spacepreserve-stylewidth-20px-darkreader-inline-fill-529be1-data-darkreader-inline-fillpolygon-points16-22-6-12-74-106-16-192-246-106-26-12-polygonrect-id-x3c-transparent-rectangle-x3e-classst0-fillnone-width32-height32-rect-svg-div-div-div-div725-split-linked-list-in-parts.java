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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        while(node != null) {
            size++;
            node = node.next;
        }
        
        ListNode[] nodes = new ListNode[k];
        node = new ListNode(-1, head);
        
        for(int i = 0; node != null && i < k; i++) {
            nodes[i] = node.next;
            node.next = null;
            node = nodes[i];
            for(int j = 1; node != null && j < (int)(Math.ceil((double)(size -i) /k)); j++) {
                node = node.next;
            }
        }
        
        return nodes;
    }
}