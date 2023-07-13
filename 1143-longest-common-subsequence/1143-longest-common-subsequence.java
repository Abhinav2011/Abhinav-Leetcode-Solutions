class Solution {
    public int helper(int i, int j, String text1, String text2, int[][] cache) {
        if(i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if(cache[i][j] != -1) {
            return cache[i][j];
        }
        int take = 0,notTake = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            take = 1 + helper(i + 1,j + 1,text1,text2,cache);
        }
        notTake = Math.max(helper(i + 1,j,text1,text2,cache), helper(i,j + 1,text1,text2,cache));

        return cache[i][j] = Math.max(take, notTake);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();++i) {
            for(int j=0;j<text2.length();++j) {
                cache[i][j] = -1;
            }
        }
        return helper(0, 0, text1, text2, cache);
    }
}