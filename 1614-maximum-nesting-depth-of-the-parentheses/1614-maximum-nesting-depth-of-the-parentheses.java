class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int openBrackets = 0;

        for (Character ch :s.toCharArray()) {
            if (ch == '(') {
                openBrackets++;
            } else if (ch == ')') {
                openBrackets--;
            }

            count = Math.max(count, openBrackets);
        }

        return count;
    }
}