class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char,int>> charStack;

        for(int index=0;index<s.length();++index) {
            if(charStack.empty()) {
                charStack.push({s[index], 1});
                continue;
            }

            if(charStack.top().second == k) {
                int temp = k;
                while(temp--) {
                    charStack.pop();
                }
            }
            if(!charStack.empty() && charStack.top().first == s[index]) {
                int currCount = charStack.top().second;
                charStack.push({s[index], currCount + 1});
            }
            else {
                charStack.push({s[index], 1});
            }
        }
        if(charStack.top().second == k) {
            int temp = k;
            while(temp--) {
                charStack.pop();
            }
        }

        string rem;
        while(!charStack.empty()) {
            rem.push_back(charStack.top().first);
            charStack.pop();
        }
        reverse(rem.begin(),rem.end());
        return rem;

    }
};