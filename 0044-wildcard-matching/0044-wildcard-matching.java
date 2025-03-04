class Solution {
   private boolean search(int i, int j, String s, String p, Boolean[][] cache) {
        if(i == s.length() && j == p.length()) {
            return true;
        }
        if(i > s.length() || j > p.length()) {
            return false;
        }

        if(cache[i][j] != null) {
            return cache[i][j];
        }

        if(i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
            Boolean res = search(i + 1, j + 1,s,p,cache);
            cache[i][j] = res;
            return res;
        }

        if(j < p.length() && p.charAt(j) == '*') {
            Boolean res = search(i + 1,j,s,p,cache) || search(i,j+1,s,p,cache);
            cache[i][j] = res;
            return res;
        }
        cache[i][j] = false;
        return false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];
        return search(0,0,s,p,cache);
    }
}