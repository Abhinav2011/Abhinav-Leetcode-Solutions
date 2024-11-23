class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] arr : prerequisites) {
            int dest = arr[0];
            int source = arr[1];
            map.computeIfAbsent(source, k -> new ArrayList<>()).add(dest);
        }
        int[] inEdge = new int[numCourses];
        for(int key : map.keySet()) {
            List<Integer> edges = map.getOrDefault(key, new ArrayList<>());
            for(int i : edges) {
                inEdge[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;++i) {
            if(inEdge[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            int node = q.poll();
            List<Integer> edges = map.getOrDefault(node, new ArrayList<>());
            for(int edge : edges) {
                inEdge[edge]--;
                if(inEdge[edge] == 0) {
                    q.offer(edge);
                }
            }
        }
        for(int i=0;i<numCourses;++i) {
            if(inEdge[i] > 0) {
                return false;
            }
        }
        return true;
    }
}