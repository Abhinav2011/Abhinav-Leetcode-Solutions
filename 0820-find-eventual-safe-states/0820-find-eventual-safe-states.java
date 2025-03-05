class Solution {
    private boolean isTerminal(int curr, HashMap<Integer, List<Integer>> map, HashSet<Integer> terminal, HashSet<Integer> visited) {
        if(terminal.contains(curr)) {
            return true;
        }
        if(visited.contains(curr)) {
            return false;
        }
        visited.add(curr);
        List<Integer> nei = map.getOrDefault(curr, new ArrayList<>());
        boolean val = true;
        for(int i : nei) {
            val = val && isTerminal(i, map, terminal, visited);
            if(val) {
                terminal.add(i);
            }
        }
        return val;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        HashSet<Integer> terminal = new HashSet<>();
        int nodes = graph.length;

        for(int i=0;i<nodes;++i) {
            int[] row = graph[i];
            if(row.length == 0) {
                terminal.add(i);
            }
            for (int k : row) {
                map.computeIfAbsent(i, (key) -> new ArrayList<>()).add(k);
            }
        }
        System.out.println(map);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nodes;++i) {
            if(terminal.contains(i)) {
                res.add(i);
                continue;
            }
            HashSet<Integer> visited = new HashSet<>();
            if(isTerminal(i, map, terminal, visited)) {
                res.add(i);
                // terminal.add(i);
            }
        }
        
        return res;

    }
}
// 1 0 2 3 