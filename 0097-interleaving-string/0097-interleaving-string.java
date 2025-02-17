class Solution {
    private boolean search(int i, int j, int k, String s1, String s2, String s3, int[][][] cache) {
        //i -> s1
        //j -> s2
        //k -> s3

        if(k == s3.length()) {
            return true;
        }
        if(i < s1.length() && j < s2.length() && s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
            return false;
        }

        if(cache[i][j][k] != -1) {
            return (cache[i][j][k] == 1) ? true : false;
        }

        if(i >= s1.length()) {
            if(s2.charAt(j) == s3.charAt(k)) {
                boolean res = search(i,j+1,k+1,s1,s2,s3,cache);
                cache[i][j][k] = (res == true) ? 1 : 0;
                return res;
            }
            cache[i][j][k] = 0;
            return false;
        }

        if(j >= s2.length()) {
            if(s1.charAt(i) == s3.charAt(k)) {
                boolean res = search(i+1,j,k+1,s1,s2,s3,cache);
                cache[i][j][k] = (res == true) ? 1 : 0;
                return res;
            }
            cache[i][j][k] = 0;
            return false;
        }
        boolean res = false;
        if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            res = search(i + 1,j,k + 1,s1,s2,s3,cache) || search(i,j + 1,k + 1,s1,s2,s3,cache);
        }
        else if(s1.charAt(i) == s3.charAt(k)) {
            res = search(i + 1,j,k + 1,s1,s2,s3,cache);
        }
        else if(s2.charAt(j) == s3.charAt(k)){
            res = search(i,j + 1,k + 1,s1,s2,s3,cache);
        }
        cache[i][j][k] = (res == true) ? 1 : 0;
        return res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][][] cache = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        for(int[][] r : cache) {
            for(int[] c : r) {
                Arrays.fill(c, -1);
            }
        }
        return search(0,0,0,s1,s2,s3,cache);
    }
}