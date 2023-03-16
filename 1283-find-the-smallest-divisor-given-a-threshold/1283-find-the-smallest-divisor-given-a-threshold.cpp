class Solution {
public:
    bool check(vector<int>& nums,int mid,int threshold){
        int sum = 0;
        for(int i=0;i<nums.size();++i){
            int curr = ceil((double)(nums[i]) / mid);
            sum += curr;
        }
        
        return (sum <= threshold) ? true : false;
    }
    
    int smallestDivisor(vector<int>& nums, int threshold) {
        int lo = 1,hi = INT_MAX;
        int mid,ans;
        
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            
            if(check(nums,mid,threshold)){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
};