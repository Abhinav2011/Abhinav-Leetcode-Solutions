class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;

        //first start with index - 0
        int currentMaxSum = nums[0];
        int maxSum = nums[0];
        int currentMinSum = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];
        for(int i=1;i<len;++i) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
            
            currentMinSum = Math.min(nums[i], currentMinSum + nums[i]);
            minSum = Math.min(minSum, currentMinSum);
            
            totalSum += nums[i];
        }
        System.out.println(maxSum + " " + minSum + " " + totalSum);
        if(minSum == totalSum) {
            return maxSum;
        }
        maxSum = Math.max(maxSum, totalSum - minSum);
        return maxSum;
    }
}