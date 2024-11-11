

//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(N == 0) return ans;
        
        boolean[] prime = new boolean[N+2];
        
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        
        for(int i=2; i<=N; ++i){
            if(prime[i] == true) ans.add(i);
            
            int j=i*2;
            while(j<=N){
                prime[j] = false;
                j += i;
            }
        }
        return ans;
        
    }
}