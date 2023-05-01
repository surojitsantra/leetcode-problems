class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        
        long sum = 0;
        
        for(int sal :salary) {
            sum += sal;
            minSalary = Math.min(minSalary, sal);
            maxSalary = Math.max(maxSalary, sal);
        }
        
        return ((double)(sum -minSalary -maxSalary) /(salary.length -2));
    }
}