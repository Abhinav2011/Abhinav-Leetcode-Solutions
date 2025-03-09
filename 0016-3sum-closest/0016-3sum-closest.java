class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minSum = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len;++i) {
            int rem = target - nums[i];
            int left = i + 1, right = len - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                int distance = target - (nums[i] + sum);
                if(Math.abs(distance) < Math.abs(minDistance)) {
                    minDistance = distance;
                    minSum = nums[i] + sum;
                }
                if(sum > rem) {
                    right--;
                }
                else if(sum < rem) {
                    left++;
                }
                else {
                    return target;
                }
            }
        }
        return minSum;
    }
}