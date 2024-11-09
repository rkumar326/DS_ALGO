class Solution {
    public long minEnd(int n, int x) {
        // Most trickiest question
        long num = x;
        for (int i = 1; i < n; i++) {
            // Increment num and perform bitwise OR with x
            num = (num + 1) | x;
        }
        return num;
    }
}