class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circularStudentCount = 0;
        int squareStudentCount = 0;
        
        for(int student :students) {
            circularStudentCount += 1 -student;
            squareStudentCount += student;
        }
        
        for(int sandwich :sandwiches) {
            if(sandwich == 0 && circularStudentCount == 0) {
                return squareStudentCount;
            }
            if(sandwich == 1 && squareStudentCount == 0) {
                return circularStudentCount;
            }
            
            squareStudentCount -= sandwich;
            circularStudentCount -= 1 -sandwich;
            
        }
        
        return 0;
    }
}