class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public boolean isSafe(int row,int col,int i,int j) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }
    public void dfs(int i,int j,int row,int col,int[][] grid) {
        grid[i][j] = 2;

        for(int k=0;k<4;++k) {
            int new_i = i + dx[k];
            int new_j = j + dy[k];

            if(isSafe(row,col,new_i,new_j) && grid[new_i][new_j] == 1) {
                dfs(new_i,new_j,row,col,grid);
            }
        }
    }
    class Index {
        public int x;
        public int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestBridge(int[][] grid) {
         //first convert first island to 2
        int row = grid.length;
        int col = grid[0].length;
        boolean done = false;
        for(int i=0;i<row;++i) {
            for(int j=0;j<col;++j) {
                if(grid[i][j] == 1) {
                    dfs(i,j,row,col,grid);
                    done = true;
                    break;
                }
            }
            if(done) {
                break;
            }
        }

        Queue<Index> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;++i) {
            for(int j=0;j<col;++j) {
                visited[i][j] = false;
                if (grid[i][j] == 2) {
                    q.add(new Index(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int shortestDistance = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Index curr = q.poll();
                if(grid[curr.x][curr.y] == 1) {
                    return shortestDistance - 1;
                }
                for(int k=0;k<4;++k) {
                    int new_i = curr.x + dx[k];
                    int new_j = curr.y + dy[k];
                    Index newCurr = new Index(new_i,new_j);
                    if(isSafe(row,col,new_i,new_j) && !visited[new_i][new_j] && (grid[new_i][new_j] == 0 || grid[new_i][new_j] == 1)) {
                        q.add(new Index(new_i,new_j));
                        visited[new_i][new_j] = true;
                    }
                }
                size--;
            }
            shortestDistance++;
        }
        return shortestDistance - 1;
    }
}
