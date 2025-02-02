class DSU {
    public int[] parent;
    public int[] size;

    public DSU(int n) {
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        for(int i=1;i<=n;++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int value) {
        if(parent[value] != value) {
            System.out.println("Value is - " + value + " and parent value is - " + parent[value]);
            parent[value] = find(parent[value]);
        }
        return parent[value];
    }

    public void mergeBySize(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY) {
            return;
        }

        if(size[parentX] < size[parentY]) {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        else {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        }
    }


}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU disjointSet = new DSU(n);
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            int parentX = disjointSet.find(from);
            int parentY = disjointSet.find(to);
            
            if(parentX == parentY) {
                return new int[]{from, to};
            }
            disjointSet.mergeBySize(from, to);
        }
        return null;
    }
}