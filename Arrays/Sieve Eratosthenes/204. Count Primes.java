class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n==1 ) return 0;
    
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);

        prime[0] = false;
        prime[1] = false;
        int ans = 0;

        for(int i=2; i<n; ++i){
            if(prime[i] == true){
                ans++;
            }

            int j = 2*i;
            while(j < n){
                prime[j] = false;
                j += i;
            }
        }
        return ans;
    }
}