// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

//Approach - Simple using OR property and sliding window
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
      
        int i=0, j=0, maxLen=Integer.MIN_VALUE, currLen=0;
        while(j<n){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);

            while(i<j && mp.containsKey(nums[j]) && mp.get(nums[j]) > k){
                if(mp.containsKey(nums[i])){
                    mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}

//Approach-2 (Without nested loop)
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int result = 0;
        
        int culprit = 0;
        
        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            if(map.get(nums[j]) == k + 1) {
                culprit++;
            }
            
            if(culprit > 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == k) {
                    culprit--;
                }
                i++;
            }
            
            if(culprit == 0) {
                result = Math.max(result, j - i + 1);
            }
            j++;
        }
        
        return result;
    }
}