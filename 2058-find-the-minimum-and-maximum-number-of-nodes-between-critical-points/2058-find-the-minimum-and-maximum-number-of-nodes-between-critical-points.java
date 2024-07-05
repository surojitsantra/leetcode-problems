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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int firstPoint = -1;
        int prevPoint = -1;
        int curPoint = -1;
        int minDis = Integer.MAX_VALUE;
        int maxDis = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        int i = 1;
        while(curr != null && curr.next != null) {
            int a = prev.val;
            int b = curr.val;
            int c = curr.next.val;
            
            boolean isMinima = ((a > b) && (b < c));
            boolean isMaxima = ((a < b) && (b > c));
            
            if(isMinima || isMaxima) {
                if(firstPoint == -1) {
                    firstPoint = prevPoint = curPoint = i;
                } else {
                    prevPoint = curPoint;
                    curPoint = i;
                    
                    minDis = Math.min(minDis, curPoint -prevPoint);
                }
            }
            
            prev = curr;
            curr = curr.next;
            i++;
        }
        
        if(firstPoint == curPoint) {
            return new int[] {-1, -1};
        }
        
        maxDis = curPoint -firstPoint;
        return new int[] {minDis, maxDis};
    }
}