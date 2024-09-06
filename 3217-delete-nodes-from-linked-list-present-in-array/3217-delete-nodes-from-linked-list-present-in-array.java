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
    public ListNode modifiedList(int[] nums, ListNode head) {
        head = new ListNode(0, head);
        
        Set<Integer> numbers = new HashSet<>();
        for(int x :nums) numbers.add(x);
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null) {
            if(numbers.contains(curr.val)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head.next;
    }
}