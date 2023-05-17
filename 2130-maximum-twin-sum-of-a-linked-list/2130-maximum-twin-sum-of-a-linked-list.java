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
    public int pairSum(ListNode head) {
        final int N = getLen(head);
        
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        
        for(int i = 1; i <= N/2; i++) {
            stack.push(node.val);
            node = node.next;
        }
        
        int maxTwin = 0;
        
        while(!stack.isEmpty() && node != null) {
            maxTwin = Math.max(maxTwin, node.val +stack.peek());
            node = node.next;
            stack.pop();
        }
        
        return maxTwin;
    }
    
    private int getLen(ListNode node) {
        int n = 0;
        
        while(node != null) {
            n++;
            node = node.next;
        }
        
        return n;
    }
}