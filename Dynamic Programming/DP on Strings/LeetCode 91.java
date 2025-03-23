class Solution {
    int n;
    int solve(String s, int i){
        if(i >=n ) return 1;
        if(s.charAt(i) == '0') return 0;

        int result = solve(s,i+1);
        if(i+1 < n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                result += solve(s,i+2); 
            }
        }
        return result;
    }
    int solveUsingMem(String s, int i, int[] dp){
        if(i >=n ) return 1;
        if(s.charAt(i) == '0') return 0;
        
        if(dp[i] != -1) return dp[i];

        int result = solveUsingMem(s,i+1,dp);
        if(i+1 < n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                result += solveUsingMem(s,i+2,dp); 
            }
        }
        dp[i] = result;
        return dp[i];
    }
    public int numDecodings(String s) {
        n = s.length();
        // return solve(s,0);
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solveUsingMem(s,0,dp);
    }
}