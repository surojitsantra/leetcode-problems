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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode list2LastNode = list2;
        while(list2LastNode.next != null) {
            list2LastNode = list2LastNode.next;
        }
        
        ListNode node = list1;
        ListNode prevNode = null;
        
        for(int i = 1; i <= a; i++) {
            prevNode = node;
            node = node.next;
        }
        
        prevNode.next = list2;
        
        for(int i = a; i <= b; i++) {
            node = node.next;
        }
        
        list2LastNode.next = node;
        
        return list1;
    }
}