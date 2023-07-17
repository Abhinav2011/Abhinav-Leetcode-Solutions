class DisjointSet {
    private int[] parent;
    private int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
    public void unionBySize(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public int[] getParent() {
        return parent;
    }
    public int[] getSize() {
        return size;
    }

}
class Solution {
    
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};

    public boolean isSafe(int i, int j, int row, int col) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DisjointSet disjointSet = new DisjointSet(row * col);

        for(int i=0;i<row;++i) {
            for(int j=0;j<col;++j) {
                if(grid[i][j] == 1) {
                    for(int k=0;k<4;++k) {
                        int new_i = i + dr[k];
                        int new_j = j + dc[k];
                        if(isSafe(new_i,new_j,row,col) && grid[new_i][new_j] == 1) {
                            int nodeNumber = i * row + j;
                            int adjNodeNumber = new_i * row + new_j;
                            disjointSet.unionBySize(nodeNumber, adjNodeNumber);
                        }
                    }
                }
            }
        }
        for(int c=0;c<disjointSet.getParent().length;++c) {
            System.out.println(disjointSet.getParent()[c]);
        }
        int largestArea = 0;
        for(int i=0;i<row;++i) {
            for (int j = 0; j < col; ++j) {
                if(grid[i][j] == 0) {
                    int currentSize = 0;
                    HashSet<Integer> components = new HashSet<>();
                    for(int k=0;k<4;++k) {
                        int new_i = i + dr[k];
                        int new_j = j + dc[k];

                        if(isSafe(new_i, new_j, row, col) && grid[new_i][new_j] == 1) {
                            components.add(disjointSet.find(new_i * row + new_j));
                        }
                    }
                    for(Integer val : components) {
                        currentSize += disjointSet.getSize()[val];
                    }
                    largestArea = Math.max(largestArea, currentSize + 1);
                }
            }
        }
        for(int i=0;i<row*col;++i) {
            int par = disjointSet.find(i);
            largestArea = Math.max(largestArea, disjointSet.getSize()[par]);
        }
        return largestArea;
    }
}