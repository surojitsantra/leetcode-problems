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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val -node2.val);
        for(ListNode list :lists) {
            if(list != null) minHeap.add(list);
        }
        
        ListNode head = new ListNode(0);
        ListNode currNode = head;
        
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            currNode.next = node;
            currNode = node;
            if(node.next != null) minHeap.add(node.next);
            currNode.next = null;
        }
        
        return head.next;
    }
}