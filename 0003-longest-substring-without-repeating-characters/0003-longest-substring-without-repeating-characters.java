class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, longestSubstringLength = 0;
        while(right < len) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) {
                while (left < right && map.get(c) > 1) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if(map.get(c) == 0) {
                        map.remove(c);
                    }
                    left++;
                }
            }
            longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);
            right++;
        }
        return longestSubstringLength;
    }
}