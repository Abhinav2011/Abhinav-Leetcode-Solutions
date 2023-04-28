class Solution {
public:
    bool canJump(vector<int>& nums) {
        int arrayLength = nums.size();
        int currentJump = nums[0];
        if(arrayLength == 1) {
            return true;
        }
        if(currentJump == 0) {
            return false;
        }
        for(int index=1;index<arrayLength;++index) {
            if(index == arrayLength - 1) {
                return true;
            }
            currentJump--;
            if(nums[index] > currentJump) {
                currentJump = nums[index];
            }
            if(currentJump == 0) {
                return false;
            }
        }
        return false;
    }
};