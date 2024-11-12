// Submitted
class Solution {
    private int customBinarySearch(int[][] items, int queryPrice) {
        int left = 0;
        int right = items.length - 1;
        int maxBeauty = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] > queryPrice) {
                right = mid - 1; // Move to the left side
            } else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                left = mid + 1;
            }
        }

        return maxBeauty;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int[] result = new int[m];

        // Step 1: Sort the items based on price in ascending order
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // Update beauty values to make them non-decreasing
        int maxBeautySeen = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            items[i][1] = maxBeautySeen;
        }

        // Process each query using custom binary search
        for (int i = 0; i < m; i++) {
            int queryPrice = queries[i];
            result[i] = customBinarySearch(items, queryPrice);
        }

        return result;
    }
}

// Brute force  (TLE)(Maine likha h)
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // It will sort the items based on first column
        Arrays.sort(items, (a,b)->(a[0]-b[0]));
        int row = items.length;

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; ++i){
            int query = queries[i];
            int beauty = 0;
            for(int j=0; j<row; j++){
                int price = items[j][0];
                if(price <= query){
                    beauty = Math.max(beauty,items[j][1]);
                    ans[i]= beauty;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}