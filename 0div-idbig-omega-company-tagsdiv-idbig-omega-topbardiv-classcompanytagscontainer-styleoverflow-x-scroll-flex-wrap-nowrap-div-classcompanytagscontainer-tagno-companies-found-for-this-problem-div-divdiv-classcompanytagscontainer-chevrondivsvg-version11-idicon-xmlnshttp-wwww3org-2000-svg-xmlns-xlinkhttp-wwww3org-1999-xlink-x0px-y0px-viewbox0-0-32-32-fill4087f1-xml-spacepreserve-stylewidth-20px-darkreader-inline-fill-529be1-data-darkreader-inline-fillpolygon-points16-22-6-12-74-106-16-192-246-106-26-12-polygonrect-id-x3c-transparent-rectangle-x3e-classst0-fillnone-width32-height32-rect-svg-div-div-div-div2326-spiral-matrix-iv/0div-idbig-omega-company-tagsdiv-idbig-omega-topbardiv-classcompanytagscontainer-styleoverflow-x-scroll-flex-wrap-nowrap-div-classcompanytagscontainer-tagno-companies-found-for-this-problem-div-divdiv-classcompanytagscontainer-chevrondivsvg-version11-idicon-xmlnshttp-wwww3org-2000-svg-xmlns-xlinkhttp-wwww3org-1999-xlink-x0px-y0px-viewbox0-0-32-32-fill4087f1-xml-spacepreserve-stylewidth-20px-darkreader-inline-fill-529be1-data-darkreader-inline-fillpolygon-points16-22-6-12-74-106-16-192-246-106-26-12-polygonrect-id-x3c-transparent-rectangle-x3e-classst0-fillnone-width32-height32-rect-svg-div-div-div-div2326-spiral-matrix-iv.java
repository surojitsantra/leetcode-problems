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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int[] row :matrix) Arrays.fill(row, -1);
        
        ListNode node = head;
        int startRow = 0, startCol = 0, endRow = m -1, endCol = n -1;
        
        while(node != null) {
            for(int col = startCol; node != null && col <= endCol; col++) {
                matrix[startRow][col] = node.val;
                node = node.next;
            }
            startRow++;
            
            for(int row = startRow; node != null && row <= endRow; row++) {
                matrix[row][endCol] = node.val;
                node = node.next;
            }
            endCol--;
            
            for(int col = endCol; node != null && col >= startCol; col--) {
                matrix[endRow][col] = node.val;
                node = node.next;
            }
            endRow--;
            
            for(int row = endRow; node != null && row >= startRow; row--) {
                matrix[row][startCol] = node.val;
                node = node.next;
            }
            startCol++;
        }
        
        return matrix;
    }
}