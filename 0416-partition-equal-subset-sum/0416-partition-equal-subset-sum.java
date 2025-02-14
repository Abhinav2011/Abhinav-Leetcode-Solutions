class Solution {
    private boolean canDivide(int index, int target, int[] nums, int[][] cache) {
        if(target == 0) {
            return true;
        }
        if(target < 0 || index >= nums.length) {
            return false;
        }

        if(cache[index][target] != -1) {
            return cache[index][target] == 1;
        }

        boolean take = canDivide(index + 1, target - nums[index], nums, cache);
        boolean dontTake = canDivide(index + 1, target, nums, cache);
        if(take || dontTake) {
            cache[index][target] = 1;
        }
        else {
            cache[index][target] = 0;
        }
        return take || dontTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] cache = new int[nums.length + 1][target + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        boolean res = canDivide(0, target, nums, cache);
        return res;
    }
}