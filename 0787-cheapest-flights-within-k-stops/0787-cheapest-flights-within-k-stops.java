class Solution {
    class Node {
        public int destination;
        public int price;

        public Node(int destination, int price) {
            this.destination = destination;
            this.price = price;
        }
    }

    class FlightTracker {
        public int flight;
        public int stops;
        
        public int cost;
        public FlightTracker(int flight, int stops, int cost) {
            this.flight = flight;
            this.stops = stops;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //build the graph
        HashMap<Integer,List<Node>> graph = new HashMap<>();
        for(int[] flight : flights) {
            int sourceFlight = flight[0];
            int destFlight = flight[1];
            int price = flight[2];
            graph.putIfAbsent(sourceFlight, new ArrayList<>());
            List<Node> list = graph.get(sourceFlight);
            list.add(new Node(destFlight, price));
            graph.put(sourceFlight, list);
        }

        PriorityQueue<FlightTracker> q = new PriorityQueue<>((a,b) -> Integer.compare(b.cost,a.cost));
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        q.add(new FlightTracker(src, 0,0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int index=0;index<size;++index) {
                FlightTracker currentFlight = q.poll();
                // if(currentFlight.flight == dst) {
                //     return distance[dst];
                // }
                List<Node> adajacentFlights = graph.getOrDefault(currentFlight.flight, new ArrayList<>());
                for(Node node : adajacentFlights) {
                     if(currentFlight.stops <= k && (currentFlight.cost + node.price < distance[node.destination])) {
                        distance[node.destination] = currentFlight.cost + node.price;
                        q.add(new FlightTracker(node.destination, currentFlight.stops + 1,distance[node.destination]));
                    }
                }
            }
        }

        return (distance[dst] == Integer.MAX_VALUE) ? -1 : distance[dst];
    }
}