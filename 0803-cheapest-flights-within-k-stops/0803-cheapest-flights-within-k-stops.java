class Solution {
    class Edge {
        public int flight;
        public int cost;

        public Edge(int flight, int cost) {
            this.flight = flight;
            this.cost = cost;
        }
    }

    class Node {
        public int stops;
        public int flight;
        public int cost;

        public Node(int stops,int flight,int cost) {
            this.stops = stops;
            this.flight = flight;
            this.cost = cost;
        }
    }
    public HashMap<Integer, List<Edge>> buildGraph(int n, int[][] flights) {
        HashMap<Integer, List<Edge>> graph = new HashMap<>();

        for(int index=0;index<flights.length;++index) {
            int u = flights[index][0];
            int v = flights[index][1];
            int cost = flights[index][2];

            List<Edge> existingNei = graph.getOrDefault(u, new ArrayList<>());
            existingNei.add(new Edge(v,cost));
            graph.put(u, existingNei);
        }

        return graph;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Edge>> graph = buildGraph(n, flights);
        int[] priceTracker = new int[n];
        for(int i=0;i<n;++i){
            priceTracker[i] = Integer.MAX_VALUE;
        }
        priceTracker[src] = 0;
        Queue<Node> flightQueue = new LinkedList<>();
        flightQueue.offer(new Node(0,src,0));

        while(!flightQueue.isEmpty()) {
            int size = flightQueue.size();

            for(int i=0;i<size;++i) {
                Node currentFlight = flightQueue.poll();
               
                List<Edge> nei = graph.getOrDefault(currentFlight.flight, new ArrayList<>());
                if(nei.size() == 0) continue;
                for(Edge edge : nei) {
                    if(currentFlight.cost + edge.cost < priceTracker[edge.flight] && currentFlight.stops <= k) {
                        if(currentFlight.stops == k) {
                            if(edge.flight == dst) {
                                priceTracker[edge.flight] = currentFlight.cost + edge.cost;
                                flightQueue.offer(new Node(currentFlight.stops + 1, edge.flight, priceTracker[edge.flight]));
                            }
                        }
                        else {
                            priceTracker[edge.flight] = currentFlight.cost + edge.cost;
                            flightQueue.offer(new Node(currentFlight.stops + 1, edge.flight, priceTracker[edge.flight]));
                        }
                        
                    }
                }   
            }
        }

        if(priceTracker[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return priceTracker[dst];
    }
}