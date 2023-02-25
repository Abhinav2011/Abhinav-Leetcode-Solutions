class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            if(map.get(s.charAt(right)) > 1){
                while(left < right && map.get(s.charAt(right)) > 1){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
            }
            ans = Math.max(ans,right - left + 1);
            right++;
        }
        return ans;
    }
}
