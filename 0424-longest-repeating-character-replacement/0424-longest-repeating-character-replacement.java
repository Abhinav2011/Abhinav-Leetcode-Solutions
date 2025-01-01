class Solution {
    public int characterReplacement(String s, int k) {
        int[] charMap = new int[26];
        Arrays.fill(charMap, 0);
        int left = 0;
        int maxSubstringPossible = 0;
        int maxCount = 0;
        for(int right=0;right<s.length();++right) {
            char c = s.charAt(right);
            charMap[c - 'A']++;
            maxCount = Math.max(maxCount, charMap[c - 'A']);
            
            while((right - left + 1) - maxCount > k) {
                charMap[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxSubstringPossible = Math.max(maxSubstringPossible, right - left + 1);
        }
        return maxSubstringPossible;
    }
}