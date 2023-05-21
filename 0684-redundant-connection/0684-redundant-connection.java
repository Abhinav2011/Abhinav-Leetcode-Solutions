class Solution {
    public int find(int x, int[] parent) {
        if(parent[x] == x) {
            return parent[x];
        } 
        return find(parent[x], parent);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        int[] parent = new int[nodes + 1];

        for(int i=1;i<=nodes;++i) {
            parent[i] = i;
        }
        int[] redundantEdge = new int[2];
        for(int i=0;i<nodes;++i) {
            int u = find(edges[i][0], parent);
            int v = find(edges[i][1], parent);
            System.out.println(u + " " + v);
            if(u != v) {
                parent[v] = u;
            }
            else{
                redundantEdge[0] = edges[i][0];
                redundantEdge[1] = edges[i][1]; 
                break;
            }
        }
        return redundantEdge;
    }
}