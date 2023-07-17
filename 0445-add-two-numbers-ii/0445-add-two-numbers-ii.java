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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = getNumbers(l1);
        Stack<Integer> stack2 = getNumbers(l2);
        ListNode res = null;
        
        int carry = 0;
        
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int x = 0;
            if(!stack1.isEmpty()) x += stack1.pop();
            if(!stack2.isEmpty()) x += stack2.pop();
            x += carry;
            
            res = new ListNode(x %10, res);
            carry = x /10;
        }
        return res;
    }
    
    private Stack<Integer> getNumbers(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }
        
        return stack;
    }
}