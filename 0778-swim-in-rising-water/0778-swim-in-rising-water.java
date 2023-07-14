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

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    public boolean isSafe(int row,int col,int i, int j) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }

    public int swimInWater(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,grid[0][0]));
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i) {
            for(int j=0;j<grid[0].length;++j) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = grid[0][0];
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Node curr = q.poll();

                for(int k=0;k<4;++k) {
                    int new_x = dx[k] + curr.x;
                    int new_y = dy[k] + curr.y;

                    if(isSafe(grid.length, grid[0].length, new_x, new_y)) {
                        int newDistance = Math.max(curr.time, grid[new_x][new_y]);
                        // System.out.println(grid[curr.x][curr.y] + "->" + newDistance);
                        if(newDistance < distance[new_x][new_y]) {
                            q.add(new Node(new_x,new_y,newDistance));
                            distance[new_x][new_y] = newDistance;
                        }
                    }
                }
            }
        }
        return distance[grid.length - 1][grid[0].length - 1];
    }
}

