/******************************************************** JAVA ********************************************************/
//Approach - Simply using XOR properties
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate the total XOR of all elements in nums
        int XOR = 0;
        for (int num : nums) {
            XOR ^= num;
        }

        // Create a mask with all bits set to 1, based on maximumBit
        int mask = (1 << maximumBit) - 1;

        // Calculate the result by finding the maximum XOR for each element
        for (int i = 0; i < n; i++) {
            // XOR ^ mask will give the flipped value of XOR, which is the best K
            result[i] = XOR ^ mask;

            // Update XOR by removing the last element in the reversed order
            XOR ^= nums[n - 1 - i];
        }

        return result;
    }
}