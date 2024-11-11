// Submitted
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        for(var i : nums){
            sum += i;
            if(mp.containsKey(sum-k)){
                ans += mp.get(sum-k);
            }

            mp.put(sum,mp.getOrDefault(sum,0)+1);
            
        }
        return ans;
    }
}

// Submitted
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        for(int i=0; i<n; ++i){
            int currSum = 0;
            for(int j=i; j<n; ++j){
                
                
                    currSum += nums[j];
          
                if(currSum == k) ans++;
            }
        }
        return ans;
    }
}

// TLE
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=i; j<n; ++j){
                int currSum = 0;
                for(int l=i; l<=j; ++l){
                    currSum += nums[l];
                }
                if(currSum == k) ans++;
            }
        }
        return ans;
    }
}