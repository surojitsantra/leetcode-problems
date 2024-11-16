class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolVsNum = new HashMap<>();
        symbolVsNum.put('I', 1);
        symbolVsNum.put('V', 5);
        symbolVsNum.put('X', 10);
        symbolVsNum.put('L', 50);
        symbolVsNum.put('C', 100);
        symbolVsNum.put('D', 500);
        symbolVsNum.put('M', 1000);
        
        final int N = s.length();
        int number = 0;
        int i = 0;
        while(i < N) {
            char currChar = s.charAt(i);
            char prevChar = (i -1 >= 0)? s.charAt(i -1) : '#';
            
            if(prevChar != '#' && symbolVsNum.get(prevChar) < symbolVsNum.get(currChar)) {
                number -= symbolVsNum.get(prevChar);
                number += (symbolVsNum.get(currChar) -symbolVsNum.get(prevChar));
            } else {
                number += symbolVsNum.get(currChar);
            }
            i++;
        }
        
        return number;
    }
}