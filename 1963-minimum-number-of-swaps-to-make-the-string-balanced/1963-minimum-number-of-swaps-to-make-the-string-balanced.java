class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch :s.toCharArray()) {
            if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        return (int)(Math.ceil(stack.size() /4.0));
    }
}