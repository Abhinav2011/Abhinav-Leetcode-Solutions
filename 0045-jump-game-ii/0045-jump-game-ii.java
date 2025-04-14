class Solution {
    private int search(int index, int[] nums, int[] cache) {
        if(index == nums.length - 1) {
            return 0;
        }
        if(index >= nums.length) {
            return 10000000;
        }
        if(cache[index] != -1) {
            return cache[index];
        }
        int jump = nums[index];
        int take = 10000000;
        for(int i=1;i<=jump;++i) {
            int val = 1 + search(index + i, nums, cache);
            take = Math.min(take, val);
        }

        return cache[index] = take;
    }
    public int jump(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return search(0, nums, cache);
    }
}