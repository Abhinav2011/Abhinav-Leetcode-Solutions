class Solution {
    private int dfs(int index, int[] cache, int[] nums, int range) {
        if(index > range) {
            return 0;
        }
        if(cache[index] != -1) {
            return cache[index];
        }
        int pick = nums[index] + dfs(index + 2, cache, nums, range);
        int notPick = dfs(index + 1, cache, nums, range);

        return cache[index] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
       int maxValueFirst = dfs(0, cache, nums, nums.length - 2);
       Arrays.fill(cache, -1);
       int maxValueSecond = dfs(1, cache, nums, nums.length - 1);
       return Math.max(maxValueFirst, maxValueSecond);
    }
}