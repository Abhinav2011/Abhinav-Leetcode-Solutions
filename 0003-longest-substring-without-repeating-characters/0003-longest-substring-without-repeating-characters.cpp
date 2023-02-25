class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> mp;
        int left = 0, right = 0, lengthLongestSubstring = 0;
        while(right < s.length()){
            mp[s[right]]++;
            
            if(mp[s[right]] > 1){
                while(left < right && mp[s[right]] > 1){
                    mp[s[left]]--;
                    left++;
                }
            }
            lengthLongestSubstring = max(lengthLongestSubstring, right - left + 1);
            right++;
        }
        return lengthLongestSubstring;
    }
};