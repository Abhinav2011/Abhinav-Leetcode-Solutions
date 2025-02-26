class Solution {
    private int search(int index, int prev, int[] nums, int[][] cache) {
        if(index >= nums.length) {
            return 0;
        }

        if(cache[index][prev + 1] != -1) {
            return cache[index][prev + 1];
        } 

        //dont take this number
        int notTake = search(index + 1, prev, nums, cache);
        int take = 0;
        //take this number if possible
        if(prev == -1 || nums[index] > nums[prev]) {
            take = 1 + search(index + 1, index, nums, cache);
        }
        
        return cache[index][prev + 1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] cache = new int[nums.length][nums.length + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return search(0,-1,nums,cache);
    }
}