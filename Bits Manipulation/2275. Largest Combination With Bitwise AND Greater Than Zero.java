2275. Largest Combination With Bitwise AND Greater Than Zero

class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int result = 0;
        // As per the constraints given for can run only upto 24 bits
        for(int i=0; i<32; ++i){
            int count = 0;
            for(var j : candidates){
                if((j & (1<<i)) != 0) ++count;
            }
            result = Math.max(result,count);
        }
        return result;
    }
}


