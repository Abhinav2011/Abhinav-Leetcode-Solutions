class Solution {
    private boolean isPresent(String x, String y, int[] count) {
        //check if x is same as y (x and y are of same length)

        int[] yCount = new int[26];
        for(int i=0;i<y.length();++i) {
            yCount[y.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;++i) {
            if(count[i] != yCount[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2 < len1) {
            return false;
        }
        int[] count = new int[26];
        for(int i=0;i<s1.length();++i) {
            count[s1.charAt(i) - 'a']++;
        }
        int window = len1;
        StringBuilder curr = new StringBuilder();
        for(int i=0;i<window;++i) {
            curr.append(s2.charAt(i));
        }
        if(isPresent(s1, curr.toString(), count)) {
            return true;
        }
        for(int i=window;i<s2.length();++i) {
            curr.deleteCharAt(0);
            curr.append(s2.charAt(i));
            if(isPresent(s1, curr.toString(), count)) {
                return true;
            }
        }
        return false;
    }
}