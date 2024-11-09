class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i=0,j=0,curr=0,maxi=0;

        while(j < n){
            int diff = Math.abs(s.charAt(j) - t.charAt(j));
            curr += diff;

            if(curr > maxCost){
                curr -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            int len = j-i + 1;
            maxi = Math.max(maxi,len);
            j++;
        }
        return maxi;
    }
}