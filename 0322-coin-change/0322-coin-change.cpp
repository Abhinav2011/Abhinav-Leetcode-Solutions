class Solution {
public:
    int findMinCoin(int index,int amount,vector<int>& coins,vector<vector<int>>& cache){
        if(amount == 0){
            return 0;
        }
        if(index == coins.size()){
            return INT_MAX - 1;
        }
        
        if(cache[index][amount] != -1){
            return cache[index][amount];
        }
        
        if(coins[index] <= amount){
            int buy = 1 + findMinCoin(index,amount - coins[index],coins,cache);
            int sell = findMinCoin(index + 1,amount,coins,cache);
            return cache[index][amount] = min(buy,sell);
        }
        
        int sell = findMinCoin(index + 1,amount,coins,cache);
        return cache[index][amount] = sell;
    }
    int coinChange(vector<int>& coins, int amount) {
       int index = 0;
        int length = coins.size();
        vector<vector<int>> cache(length + 1,vector<int>(amount + 1,-1));
       int minCoinsNeeded = findMinCoin(index,amount,coins,cache);
       if(minCoinsNeeded == INT_MAX - 1){
           return -1;
       }
       return minCoinsNeeded; 
    }
};