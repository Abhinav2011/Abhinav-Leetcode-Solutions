class Solution {
public:
    vector<vector<int>> ans;
    void helper(int index,vector<int>& candidates,int target,vector<int> temp){
        if((target != 0 && index >= candidates.size()) || target < 0){
            return;
        }
        if(target == 0 && index >= candidates.size()){
            ans.push_back(temp);
            return;
        }
        if(target == 0){
            ans.push_back(temp);
            return;
        }
        
        temp.push_back(candidates[index]);
        helper(index,candidates,target - candidates[index],temp);
        temp.pop_back();
        helper(index + 1,candidates,target,temp);
        
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        helper(0,candidates,target,{});
        return ans;
    }
};