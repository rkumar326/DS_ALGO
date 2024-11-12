
// Khud se kiya
class Solution {
    static boolean canAttend(int[][] arr) {
        // Your code here
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        
        int row = arr.length;
        for(int i=1; i<row; ++i){
            if(arr[i][0] < arr[i-1][1]){
                return false;
            }
        }
        return true;
    }
}