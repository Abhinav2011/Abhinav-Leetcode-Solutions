class Solution {
public:
    //-2147483648 -> 2^31
    //2147483647 -> 2^31 - 1
    
    
    int myAtoi(string s) {
        string ans;
        int n = s.length();
        bool positive = true;
        int i;
        for(i=0;i<n;++i){
            if(s[i] != ' '){
                if(s[i] == '-'){
                    i++;
                    positive = false;
                }
                else if(s[i] == '+'){
                    i++;
                }
                break;
            }
        }
        for(;i<n;++i){
            if(s[i] == '0'){
                continue;
            }
            else{
                break;
            }
        }
        for(;i<n;++i){
            char c = s[i];
            if(isdigit(c)){
                ans.push_back(c);
            }
            else{
                break;
            }
        }
        int len = ans.size();
        if(len > 10){
            return (positive) ? 2147483647 : -1 * 2147483648;
        }
        if(len == 10){
            if(positive){
                if(ans >= "2147483647"){
                    return 2147483647;
                }
            }
            else{
                if(ans >= "2147483648"){
                    return -1 * 2147483648;
                }
            }
        }
        int num = 0;
        for(int i=0;i<len;++i){
            int val = ans[i] - '0';
            num = (num * 10) + val;
        }
        return (positive) ? num : -1 * num;
    }
};