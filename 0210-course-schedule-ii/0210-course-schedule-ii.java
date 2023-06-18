class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int index=0;index<prerequisites.length;++index) {
            int a = prerequisites[index][0];
            int b = prerequisites[index][1];
            graph.putIfAbsent(b, new ArrayList<>());
            List<Integer> curr = graph.get(b);
            curr.add(a);
            graph.put(b, curr);
        }
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int index=0;index<numCourses;++index) {
            List<Integer> nei = graph.getOrDefault(index, new ArrayList<>());
            for(int i : nei) {
                indegree[i]++;
            }
        }
        for(int index=0;index<numCourses;++index) {
            if(indegree[index] == 0) {
                q.add(index);
            }
        }
        if(q.isEmpty()) {
            return new int[]{};
        }
        int[] order = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int index=0;index<numCourses;++index) {
            visited[index] = false;
        }
        int currIndex = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int index=0;index<size;++index) {
                int node = q.poll();
                visited[node] = true;
                order[currIndex] = node;
                currIndex++;
                List<Integer> nei = graph.getOrDefault(node, new ArrayList<>());
                System.out.println(nei);
                for(int i : nei) {
                    System.out.println(node + "->" + i);
                    if(visited[i] == true) {
                        return new int[]{};
                    }
                    indegree[i]--;
                    if(indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        int count = 0;
        for(int index=0;index<numCourses;++index) {
            if(order[index] == 0) {
                count++;
            }
        }
        if(count > 1) {
            return new int[]{};
        }
        return order;
    }
}


