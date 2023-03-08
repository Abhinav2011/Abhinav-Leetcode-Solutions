class Solution {
public:
    bool canJump(vector<int>& nums) {
        int size = nums.size();
        if(size == 1) return true;
        if(nums[0] == 0) return false;
        int currJump = nums[0];
        
        for(int i=1;i<size;++i){
            if(i == size - 1){
                return true;
            }
            currJump--;
            if(nums[i] > currJump){
                currJump = nums[i];
            }
            if(currJump == 0){
                return false;
            }
        }
        return false;
    }
};