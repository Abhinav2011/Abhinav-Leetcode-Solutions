class Solution {
    int[] dx = {0,1,0,-1};
     int[] dy = {-1,0,1,0};
    class Node {
        public int x;
        public int y;
        public int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public boolean isSafe(int row,int col,int i, int j) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }

    public int swimInWater(int[][] grid) {

        PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> Integer.compare(o1.time,o2.time));
        pq.add(new Node(0,0,grid[0][0]));
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int i=0;i<row;++i) {
            for(int j=0;j<col;++j) {
                vis[i][j] = false;
            }
        }
        vis[0][0] = true;
        int result = Integer.MIN_VALUE;
        while(!pq.isEmpty()) {
            int size = pq.size();
            while(size-- > 0) {
                Node curr = pq.poll();
                result = Math.max(curr.time, result);
                if(curr.x == grid.length - 1 && curr.y == grid[0].length - 1) {
                    return result;
                }
                for(int k=0;k<4;++k) {
                    int new_x = dx[k] + curr.x;
                    int new_y = dy[k] + curr.y;

                    if(isSafe(grid.length, grid[0].length, new_x, new_y) && !vis[new_x][new_y]) {
                        pq.add(new Node(new_x,new_y,grid[new_x][new_y]));
                        vis[new_x][new_y] = true;
                    }
                }
            }
        }
        return result;
    }
}