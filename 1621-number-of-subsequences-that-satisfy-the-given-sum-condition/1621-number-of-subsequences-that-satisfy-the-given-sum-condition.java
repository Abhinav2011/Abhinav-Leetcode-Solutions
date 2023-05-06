class Solution {
   public int numSubseq(int[] nums, int target) {
        int size = nums.length;
        int MOD = 1000000007;
        Arrays.sort(nums);
        int left = 0, right = size - 1;
        int totalSub = 0;
        int[] power = new int[size];
        power[0] = 1;
        for (int i = 1; i < size; ++i) {
            power[i] = (power[i - 1] * 2) % MOD;
        }
        while(left <= right) {
            int sum = nums[left] + nums[right];

            if(sum > target) {
                right--;
            }
            else {
                int value = power[right - left];
                totalSub += (value);
                totalSub %= MOD;
                left++;
            }
        }        

        return totalSub;
    }
}

