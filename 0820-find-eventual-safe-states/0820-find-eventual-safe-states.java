class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        HashMap<Integer, List<Integer>> reverseGraph = new HashMap<>();
        int[] outgoing = new int[nodes];
        for(int i=0;i<nodes;++i) {
            int[] row = graph[i];
            for(int k : row) {
                // System.out.println(i + " " + k);
                reverseGraph.computeIfAbsent(k, (key) -> new ArrayList<>()).add(i);
            }
            outgoing[i] = graph[i].length;
        }

        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> terminal = new HashSet<>();
        for(int i=0;i<nodes;++i) {
            if(outgoing[i] == 0) {
                q.offer(i);
            }
        }
        System.out.println(q);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int curr = q.poll();
                terminal.add(curr);
                
                List<Integer> adj = reverseGraph.getOrDefault(curr, new ArrayList<>());
                for(int nei : adj) {
                    outgoing[nei]--;
                    if(outgoing[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nodes;++i) {
            if(terminal.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}