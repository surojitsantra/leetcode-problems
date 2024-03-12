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
    public ListNode removeZeroSumSublists(ListNode head) {
        head = new ListNode(0, head);
        Map<Integer, ListNode> sumVsNodes = new HashMap<>();
        
        ListNode node = head;
        int currSum = 0;
        while(node != null) {
            currSum += node.val;
            if(sumVsNodes.containsKey(currSum)) {
                ListNode lastOccouredNode = sumVsNodes.get(currSum);
                
                int tempSum = currSum;
                ListNode tempNode = lastOccouredNode.next;
                while(tempNode != node) {
                    tempSum += tempNode.val;
                    sumVsNodes.remove(tempSum);
                    tempNode = tempNode.next;
                }
                
                lastOccouredNode.next = node.next;
            } else {
                sumVsNodes.put(currSum, node);
            }
            
            node = node.next;
        }
        
        return head.next;
    }
}