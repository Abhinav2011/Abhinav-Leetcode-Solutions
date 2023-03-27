class Node{
public:
    int stops;
    int flight;
    int price;
    Node(int stops,int flight,int price){
        this->stops = stops;
        this->flight = flight;
        this->price = price;
    }
};
class Edge{
public:
    int neiFlight;
    int price;
    Edge(int neiFlight,int price){
        this->neiFlight = neiFlight;
        this->price = price;
    }
};
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        unordered_map<int,vector<Edge> > flightGraph;
        int length = flights.size();
        for(int index=0;index<length;++index){
            int source = flights[index][0];
            int dest = flights[index][1];
            int price = flights[index][2];
            flightGraph[source].push_back(Edge(dest,price));
        }
        vector<int> priceArray(n,INT_MAX);
        priceArray[src] = 0;
        queue<Node> flightQueue;
        flightQueue.push(Node(0,src,0));

        while(!flightQueue.empty()){
            int currentQueueSize = flightQueue.size();
            while(currentQueueSize > 0){
                Node currentFlightNode = flightQueue.front();
                flightQueue.pop();
                vector<Edge> neiFlights;
                if(flightGraph.find(currentFlightNode.flight) != flightGraph.end()){
                    neiFlights = flightGraph[currentFlightNode.flight];
                }
                cout<<neiFlights.size()<<endl;
                for(int index=0;index<neiFlights.size();++index){
                    int flightName = neiFlights[index].neiFlight;
                    int flightPrice = neiFlights[index].price;
                    if(currentFlightNode.price + flightPrice < priceArray[flightName] && currentFlightNode.stops + 1 <= k + 1){
                        priceArray[flightName] = currentFlightNode.price + flightPrice;
                        flightQueue.push(Node(currentFlightNode.stops + 1,flightName,priceArray[flightName]));
                    }
                }

                currentQueueSize--;
            }
        }
        if(priceArray[dst] == INT_MAX){
            return -1;
        }
        return priceArray[dst];
    }
};