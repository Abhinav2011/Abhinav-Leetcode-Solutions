class Solution {
    int totalNeeded = 0;
    private int getMaxPath(int start, int n, int[] cost, List<Integer> tempPath) {
        if(start > n) {
            return 0;
        }

        int left = cost[start - 1] + getMaxPath(2 * start, n, cost, tempPath);
        int right = cost[start - 1] + getMaxPath(2 * start + 1, n, cost, tempPath);
        totalNeeded += Math.abs(left - right);
        return Math.max(left, right);
    }
    public int minIncrements(int n, int[] cost) {
        getMaxPath(1, n, cost, new ArrayList<>());
        return totalNeeded;
    }
}