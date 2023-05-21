class Solution {
    public void dfs(int source, Map<Integer,List<Integer>> graph, boolean[] visited) {
        visited[source] = true;
        List<Integer> edge = graph.getOrDefault(source, new ArrayList<>());
        if(edge.size() == 0) return;

        for(int i=0;i<edge.size();++i) {
            if(!visited[edge.get(i)]) {
                dfs(edge.get(i), graph, visited);
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            List<Integer> temp = graph.getOrDefault(u, new ArrayList<>());
            temp.add(v);
            graph.put(u, temp);
            temp = graph.getOrDefault(v, new ArrayList<>());
            temp.add(u);
            graph.put(v, temp);
        }
        int[] answer = new int[2];
        for(int i=0;i<edges.length;++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            removeEdge(u, v, graph);
            //perform DFS now
            boolean[] visited = new boolean[edges.length + 1]; 
            dfs(1, graph, visited);
            boolean everyNodeVisited = true;
            //check if every node has been visited
            for(int j=1;j<=edges.length;++j) {
                if(!visited[j]) {
                    everyNodeVisited = false;
                    break;
                }
            }
            if(everyNodeVisited) {
                answer[0] = u;
                answer[1] = v;
            }
            addEdge(u, v, graph);
        }
        return answer;
    }

    public void removeEdge(int u, int v, Map<Integer,List<Integer>> graph) {
        List<Integer> edge = graph.get(u);
        edge.remove(Integer.valueOf(v));
        graph.put(u, edge);
        edge = graph.get(v);
        edge.remove(Integer.valueOf(u));
        graph.put(v, edge);
    }

    public void addEdge(int u, int v, Map<Integer,List<Integer>> graph) {
        List<Integer> edge = graph.get(u);
        edge.add(v);
        graph.put(u, edge);
        edge = graph.get(v);
        edge.add(u);
        graph.put(v, edge);
    }
}


/**
build graph
go to every edge...remove that edge and do dfs
check if every node is visited..if yes add it to answer
include the removed edge for next dfs
 */