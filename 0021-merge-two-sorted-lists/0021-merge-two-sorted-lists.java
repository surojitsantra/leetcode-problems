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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101);
        ListNode node = head;
        
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
            node.next = null;
        }
        
        while(list1 != null) {
            node.next = list1;
            list1 = list1.next;
            node = node.next;
            node.next = null;
        }
        
        while(list2 != null) {
            node.next = list2;
            list2 = list2.next;
            node = node.next;
            node.next = null;
        }
        
        return head.next;
    }
}