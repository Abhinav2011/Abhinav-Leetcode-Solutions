class Solution {
public:
    int getMaxProfit(int index,bool canBuyStock,int length,vector<int>& prices,vector<vector<int>>& cache){
        if(index >= length){
            return 0;
        }
        if(cache[index][canBuyStock] != -1){
            return cache[index][canBuyStock];
        }
        int totalProfit = getMaxProfit(index + 1,canBuyStock,length,prices,cache);
        
        if(canBuyStock){
            int profitBuy = getMaxProfit(index + 1,!canBuyStock,length,prices,cache) - prices[index];
            totalProfit = max(totalProfit,profitBuy);
        }
        else{
            int profitSell = prices[index] + getMaxProfit(index + 2,!canBuyStock,length,prices,cache);
            totalProfit = max(totalProfit,profitSell);
        }
        return cache[index][canBuyStock] = totalProfit;
    }
    int maxProfit(vector<int>& prices) {
        int length = prices.size();
        bool canBuyStock = true;
        int index = 0;
        vector<vector<int>> cache(length,vector<int>(2,-1));
        return getMaxProfit(index,canBuyStock,length,prices,cache);
    }
};