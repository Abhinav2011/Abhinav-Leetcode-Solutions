class DSU {
    public int[] parent;
    public int[] size;
    
    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        
        for(int i=0;i<n;++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    //find parent
    public int find(int value) {
        if(parent[value] != value) {
            return find(parent[value]);
        }
        return parent[value];
    }
    
    //merge DSU by size
    public void mergeBySize(int x, int y) {
        //get their respective parents
        int parentX = find(x);
        int parentY = find(y);
        
        //merge the two nodes
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
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int redundantConnections = 0;
        for(int[] row : connections) {
            int x = row[0];
            int y = row[1];
            //get new parents
            int parentX = dsu.find(x);
            int parentY = dsu.find(y);
            if(parentX == parentY) {
                //this is a redundant connection
                redundantConnections++;
            }
            //merge
            dsu.mergeBySize(x, y);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<dsu.parent.length;++i) {
            int parent = dsu.find(i);
            set.add(parent);
        }
        System.out.println(set.size() + " " + redundantConnections);
        if(set.size() == 1) {
            return 0;
        }
        if((set.size() - 1) <= redundantConnections) {
            return set.size() - 1;
        }
        return -1;
    }
}