class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> lockEnds = new HashSet<>();
        for(String key :deadends) lockEnds.add(key);

        if(lockEnds.contains(target)) return -1;
        if(lockEnds.contains("0000")) return -1;
        if("0000".equals(target)) return 0;

        Queue<String> triedCombo = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        triedCombo.add("0000");
        visited.add("0000");

        int level = 0;
        while(!triedCombo.isEmpty()) {
            int sz = triedCombo.size();
            while(sz-- > 0) {
                //find all next possible combo
                String combo = triedCombo.poll();
                if(target.equals(combo)) return level;
                String[] nextCombinations = buildNextCombinations(combo);

                for(String nextCombination :nextCombinations) {
                    if(!visited.contains(nextCombination) 
                    && !lockEnds.contains(nextCombination)) {
                        triedCombo.add(nextCombination);
                        visited.add(nextCombination);
                    }
                }

            }
            level++;
        }

        return -1;

    }


    private String[] buildNextCombinations(String combo) {
        String[] nextCombination = new String[8];

        for(int i = 0; i <= 3; i++) {
            char no = combo.charAt(i);
            int prevNo = (no == '0')? 9 : (no -'0') -1;
            int nextNo = (no == '9')? 0 : (no -'0') +1;

            char prevChar = (char)('0' +prevNo);
            char nextChar = (char)('0' +nextNo);

            StringBuilder sb = new StringBuilder(combo);
        
            sb.setCharAt(i, nextChar);
            nextCombination[i *2] = new String(sb);

            sb.setCharAt(i, prevChar);
            nextCombination[i *2 +1] = new String(sb);

        }

        return nextCombination;
    }
}