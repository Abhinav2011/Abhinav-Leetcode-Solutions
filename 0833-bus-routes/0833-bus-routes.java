class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int bus=0;bus<routes.length;++bus) {
            int[] stops = routes[bus];
            for(int stop : stops) {
                graph.computeIfAbsent(stop, (key) -> new ArrayList<>()).add(bus);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        HashSet<Integer> visitedBus = new HashSet<>();
        
        for(int bus : graph.getOrDefault(source, new ArrayList<>())) {
            q.offer(bus);
            visitedBus.add(bus);
        }
        int numOfBus = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int currBus = q.poll();
                for(int stop : routes[currBus]) {
                    if(stop == target) {
                        return numOfBus;
                    }
                    if(!visitedStops.contains(stop)) {
                        visitedStops.add(stop);
                        List<Integer> buses = graph.get(stop);
                        for(int bus : buses) {
                            if(!visitedBus.contains(bus)) {
                                visitedBus.add(bus);
                                q.offer(bus);
                            }
                        }
                    }
                }
            }
            numOfBus++;
        }
        return -1;
    }
}