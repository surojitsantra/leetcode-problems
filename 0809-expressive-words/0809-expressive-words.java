class Solution {
    public int expressiveWords(String x, String[] words) {
        List<int[]> charFreq = new ArrayList<>();

        int start = 0;
        charFreq.add(new int[] {x.charAt(start), 0});
        for(int end = 0; end < x.length(); end++) {
            boolean newChar = false;
            while(start <= end && x.charAt(start) != x.charAt(end)) {
                start++;
                newChar = true;
            }

            if(newChar) {
                charFreq.add(new int[] {x.charAt(start), 0});
            }

            charFreq.getLast()[1] = end -start +1;

        }

        // for(int[] y :charFreq) {
        //     System.out.println(y[0] +"-> " +y[1]);
        // }

        int count = 0;
        for(String word :words) {
            int s = 0;
            int idx = 0;
            while(s < word.length()) {
                int e = s;
                while(e < word.length() && word.charAt(s) == word.charAt(e)) e++;

                if(idx >= charFreq.size()) break;
                if(charFreq.get(idx)[0] != word.charAt(s)) break;

                int len = e -s;
                int freq = charFreq.get(idx)[1];

                if(len > freq) break;

                if(len != freq) {
                    if(freq < 3) break;
                }

                s = e;
                idx++;
            }

            if(s >= word.length() && idx >= charFreq.size()) count++;
        }

        return count;
        
    }
}