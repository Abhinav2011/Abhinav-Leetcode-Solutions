class Solution {
    int getMax(int[] count) {
        return Arrays.stream(count).max().getAsInt();
    }
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        int maxLength = 0;
        
        for(int right=0;right<len;++right) {
            count[s.charAt(right) - 'A']++;
            int maxCharVal = getMax(count);
            int distance = right - left + 1;
            
            if((distance - maxCharVal) > k) {
                while(distance - maxCharVal > k) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                    maxCharVal = getMax(count);
                    distance = right - left + 1;
                }
            }
            else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        return maxLength;
        
    }
}