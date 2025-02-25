class Solution {
    private char getMaxChar(char prev, int[] count) {
        int maxCount = 0;
        char curr = 'A';
        for(char c='a';c<='z';++c) {
            if(count[c - 'a'] > 0 && count[c - 'a'] >= maxCount && prev != c) {
                curr = c;
                maxCount = count[curr - 'a'];
            }
        }
        return curr;
    }
    public String reorganizeString(String s) {
        int len = s.length();
        if(len == 0 || len == 1) {
            return s;
        }
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        char prev = 'A';
        int maxCount = 0;
        for(char c='a';c<='z';++c) {
            if(count[c - 'a'] > 0 && count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                prev = c;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(prev);
        count[prev - 'a']--;
        // System.out.println(prev + " " + count[prev - 'a']);
        boolean isCharRemaining = true;
        while(isCharRemaining) {
            
            prev = getMaxChar(prev, count);
            if(prev == 'A') {
                return "";
            }
            // System.out.println(prev + " " + count[prev - 'a']);
            res.append(prev);
            count[prev - 'a']--;
            
            int remCount = 0;
            for(int i=0;i<26;++i) {
                if(count[i] > 0) {
                    break;
                }
                remCount++;
            }
            if(remCount == 26) {
                isCharRemaining = false;
            }
        }
        System.out.println(res);
        return res.toString();
    }
}