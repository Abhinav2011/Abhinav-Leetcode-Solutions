class Solution {
public:
    int findMaxProfit(int index,bool canBuy,int transactionsAllowed,vector<int>& prices,vector<vector<vector<int>>> &cache){
        if(index >= prices.size() || transactionsAllowed == 0){
            return 0;
        }

        if(cache[index][canBuy][transactionsAllowed] != -1){
            return cache[index][canBuy][transactionsAllowed];
        }

        int boughtProfit = 0, sellProfit = 0;

        if(canBuy){
            int buy = findMaxProfit(index + 1,!canBuy,transactionsAllowed,prices,cache) - prices[index];
            int notBuy = findMaxProfit(index + 1,canBuy,transactionsAllowed,prices,cache);
            boughtProfit = max(buy,notBuy);
        }
        else{
            int sell = prices[index] + findMaxProfit(index + 1,!canBuy,transactionsAllowed - 1,prices,cache);
            int notSell = findMaxProfit(index + 1,canBuy,transactionsAllowed,prices,cache);
            sellProfit = max(sell,notSell);
        }

        cache[index][canBuy][transactionsAllowed] = max(boughtProfit,sellProfit);
        return cache[index][canBuy][transactionsAllowed];
    }
    int maxProfit(int k, vector<int>& prices) {
        int length = prices.size();
        int index = 0, transactionsAllowed = k;
        bool canBuy = true;
        vector<vector<vector<int>>> cache(length,vector<vector<int> >(2,vector<int>(k + 1,-1)));
        int maxProfitMade = findMaxProfit(index,canBuy,transactionsAllowed,prices,cache);
        return maxProfitMade;

    }
};