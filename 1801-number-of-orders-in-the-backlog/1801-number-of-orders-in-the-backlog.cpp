class Orders
{
    public:

    int price;
    int amount;

    Orders(int price, int amount)
    {
        this->price = price;
        this->amount = amount;
    }
};

class BuyComparator
{
    public:

        bool operator()(Orders object1, Orders object2)
        {
            return object1.price < object2.price;
        }
};

class SellComparator
{
    public:

        bool operator()(Orders object1, Orders object2)
        {
            return object1.price > object2.price;
        }
};

class Solution
{
    int MOD = 1000000007;
    public:
        int getNumberOfBacklogOrders(vector<vector < int>> &orders)
        {
            int numOrders = orders.size();
            priority_queue<Orders, vector < Orders>, BuyComparator> buyMaxHeap;

            priority_queue<Orders, vector < Orders>, SellComparator> sellMinHeap;

            for (int order = 0; order < numOrders; ++order)
            {
                Orders currOrder(orders[order][0], orders[order][1]);
                int orderType = orders[order][2];

                if (orderType == 0)
                {
                   	//buy type
                    while (!sellMinHeap.empty() && sellMinHeap.top().price <= currOrder.price && currOrder.amount > 0)
                    {
                        Orders sellOrder = sellMinHeap.top();
                        int sellPrice = sellOrder.price;
                        int buyPrice = currOrder.price;
                        int sellAmount = sellOrder.amount;
                        int buyAmount = currOrder.amount;
                        if (buyAmount > sellAmount)
                        {
                            sellMinHeap.pop();
                            currOrder.amount = buyAmount - sellAmount;
                        }
                        else
                        {
                            currOrder.amount = 0;
                            sellOrder.amount = sellAmount - buyAmount;
                            sellMinHeap.pop();
                            if (sellOrder.amount > 0)
                            {
                                sellMinHeap.push(sellOrder);
                            }
                        }
                    }

                    if (currOrder.amount > 0)
                    {
                        buyMaxHeap.push(currOrder);
                    }
                }
                else
                {
                   	//sell type
                    while (!buyMaxHeap.empty() && buyMaxHeap.top().price >= currOrder.price && currOrder.amount > 0)
                    {
                        Orders buyOrder = buyMaxHeap.top();
                        int buyPrice = buyOrder.price;
                        int sellPrice = currOrder.price;

                        int sellAmount = currOrder.amount;
                        int buyAmount = buyOrder.amount;

                        if (sellAmount > buyAmount)
                        {
                            buyMaxHeap.pop();
                            currOrder.amount = sellAmount - buyAmount;
                        }
                        else
                        {
                            currOrder.amount = 0;
                            buyOrder.amount = buyAmount - sellAmount;
                            buyMaxHeap.pop();
                            if (buyOrder.amount > 0)
                            {
                                buyMaxHeap.push(buyOrder);
                            }
                        }
                    }

                    if (currOrder.amount > 0)
                    {
                        sellMinHeap.push(currOrder);
                    }
                }
            }
            int backlogOrders = 0;
           	// cout<<sellMinHeap.size()<<" "<<buyMaxHeap.size()<<endl;
            while (!sellMinHeap.empty())
            {
                backlogOrders = ((backlogOrders % MOD) + (sellMinHeap.top().amount % MOD)) % MOD;
                sellMinHeap.pop();
            }
            while (!buyMaxHeap.empty())
            {
                backlogOrders = ((backlogOrders % MOD) + (buyMaxHeap.top().amount % MOD)) % MOD;
                buyMaxHeap.pop();
            }
            return backlogOrders;
        }
};