class Solution {
public:
    
    int maxProfit(vector<int>& prices) {
        int length = prices.size();
        int currentBoughtStock = prices[0];
        int profit = 0;
        if(length == 0){
            return 0;
        }
        
        for(int i=1;i<length;++i){
            if(prices[i] < currentBoughtStock){
                currentBoughtStock = prices[i];
            }
            else{
                profit += (prices[i] - currentBoughtStock);
                currentBoughtStock = prices[i];
            }
        }
        return profit;
    }
};