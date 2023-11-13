class Solution {
    public String sortVowels(String s) {
        
        char[] vowles= new char[] {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        int[] vowelFreq = new int[256];
        
        for(char ch :s.toCharArray()) {
            if(isVowel(ch)) {
                vowelFreq[ch]++;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        int i = 0;
        
        for(char ch :s.toCharArray()) {
            if(isVowel(ch)) {
                while(i < 10 && vowelFreq[vowles[i]] <= 0) {
                    i++;
                }
                ans.append(vowles[i]);
                vowelFreq[vowles[i]]--;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    
    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
    
}