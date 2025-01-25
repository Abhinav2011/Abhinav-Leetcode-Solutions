class Solution {
    private boolean isSafe(int x,int y, int row, int col) {
        return (x >= 0 && x < row && y >= 0 && y < col);
    }
    public int search(int x,int y,int[][] grid,int[][] cache) {
        if(!isSafe(x,y,grid.length,grid[0].length)) {
            return 1000000;
        }

        if(x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        
        if(cache[x][y] != -1) {
            return cache[x][y];
        }

        //if I go right
        int goRight = grid[x][y] + search(x + 1, y, grid,cache);
        //If I go down
        int goDown = grid[x][y] + search(x, y + 1, grid,cache);

        return cache[x][y] = Math.min(goRight, goDown);
    }

    public int minPathSum(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];
        for(int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        int minSum = search(0,0,grid,cache);
        return minSum;
    }
}