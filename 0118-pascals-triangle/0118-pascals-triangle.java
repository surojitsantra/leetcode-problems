class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        
        for(int i = 1; i <= numRows; i++) {
            List<Integer> prev = (i -2 >= 0)? pascalTriangle.get(i -2) : null;
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            
            for(int j = 1; j <= i -2; j++) {
                curr.add(prev.get(j -1) +prev.get(j));
            }
            
            if(i > 1) curr.add(1);
            pascalTriangle.add(curr);
        }
        
        return pascalTriangle;
    }
}