class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if(digits.isEmpty()) return ans;
        
        Map<Character, List<String>> numbersMap = new HashMap<>();
        numbersMap.put('2', Arrays.asList("a", "b", "c"));
        numbersMap.put('3', Arrays.asList("d", "e", "f"));
        numbersMap.put('4', Arrays.asList("g", "h", "i"));
        numbersMap.put('5', Arrays.asList("j", "k", "l"));
        numbersMap.put('6', Arrays.asList("m", "n", "o"));
        numbersMap.put('7', Arrays.asList("p", "q", "r", "s"));
        numbersMap.put('8', Arrays.asList("t", "u", "v"));
        numbersMap.put('9', Arrays.asList("w", "x", "y", "z"));
        
        getAllStrings(digits, 0, numbersMap, "", ans);
        
        return ans;
    }
    
    private void getAllStrings(String digits, int i, Map<Character, List<String>> numbersMap, String currStr, List<String> ans) {
        if(i == digits.length()) {
            ans.add(currStr);
            return;
        }
        
        for(String ch :numbersMap.get(digits.charAt(i))) {
            getAllStrings(digits, i +1, numbersMap, currStr +ch, ans);
        }
        
    }
    
}