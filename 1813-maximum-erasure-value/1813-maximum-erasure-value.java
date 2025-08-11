class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        HashSet<Integer> set = new HashSet<>();
        int currSum = 0, maxSum = 0;
        
        while(right < nums.length) {
            while(left < right && set.contains(nums[right])) {
               currSum -= nums[left];
               set.remove(nums[left]);
               left++;
            }
            set.add(nums[right]);
            currSum += nums[right];
            maxSum = Math.max(currSum, maxSum);
            right++;
        }
        return maxSum;
    }
}
 