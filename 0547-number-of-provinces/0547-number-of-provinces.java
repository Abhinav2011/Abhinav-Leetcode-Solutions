class Solution {
    public int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x], parent);
    }
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for(int i=0;i<cities;++i) {
            parent[i] = i;
        }
        int component = cities ;
        for(int i=0;i<cities;++i) {
            for(int j=0;j<cities;++j) {
                if(isConnected[i][j] == 1) {
                    int parent_i = find(i, parent);
                    int parent_j = find(j, parent);
                    if(parent_i != parent_j) {
                        component--;
                        parent[parent_i] = parent_j;
                    }
                }
            }
        }
        
        return component == 0 ? 1 : component;
    }
}