class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int max_here = 0, max_global = INT_MIN;
        
        for(int i=0;i<n;++i){
            max_here += nums[i];
            if(max_here < 0){
                max_global = max(max_global,max_here);
                max_here = 0;
                continue;
            }
            max_global = max(max_global,max_here);
            
        }
        return max_global;
    }
};