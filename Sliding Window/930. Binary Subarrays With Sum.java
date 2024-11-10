// Sliding Window
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int i=0, j=0, currSum=0, ans = 0, zeros=0;

        while(j < n){
            currSum += nums[j];

            while(i<j && (nums[i] == 0 || currSum > goal)){
                if(nums[i] == 0){
                    zeros++;
                }else{
                    zeros = 0;
                }

                currSum -= nums[i];
                i++;
            }

            if(currSum == goal){
                ans += 1 + zeros;
            }
            j++;
        }
        return ans;
    }
}

// Brute Force (Submitted)
// TC = O(n^2)
// SC = O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int ans = 0;
        for(int i=0; i<n; ++i){
            int currSum = 0;
            for(int j=i; j<n; ++j){
                currSum += nums[j];
            
                if(currSum == goal) ans++;
            }
        }
        return ans;
    }
}



// Brute Force (TLE)
// TC = O(n^3)
// SC = O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=i; j<n; ++j){
                int currSum = 0;
                for(int k=i; k<=j; ++k){
                    currSum += nums[k];
                }
                if(currSum == goal) ans++;
            }
        }
        return ans;
    }
}