class Solution {
    class Node {
        public int dest;
        public int time;

        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
         HashMap<Integer, List<Node>> graph = new HashMap<>();
        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int timeTaken = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            List<Node> list = graph.get(u);
            list.add(new Node(v, timeTaken));
            graph.put(u, list);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>((Node n1, Node n2) -> Integer.compare(n2.time, n1.time));
        q.add(new Node(k, 0));
        distance[k] = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node currNode = q.poll();
                List<Node> neiList = graph.getOrDefault(currNode.dest, new ArrayList<>());
                for(Node neiNode : neiList) {
                    int nei = neiNode.dest;
                    int timeTaken = neiNode.time;

                    if(distance[currNode.dest] + timeTaken < distance[nei]) {
                        distance[nei] = distance[currNode.dest] + timeTaken;
                        q.add(new Node(nei, distance[nei]));
                    }
                }
                size--;
            }
        }
        int minTimeTaken = 0;
        for(int index=1;index<=n;++index) {
            if(distance[index] == Integer.MAX_VALUE) {
                return -1;
            }
            minTimeTaken = Math.max(minTimeTaken, distance[index]);
            System.out.println(distance[index]);
        }
        return minTimeTaken;
    }
}