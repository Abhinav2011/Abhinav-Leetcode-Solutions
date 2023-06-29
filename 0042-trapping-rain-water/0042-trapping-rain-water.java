class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = height[left], rightMax = height[right];
        int trappedWater = 0;
        while(left < right) {
            if(leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += (leftMax - height[left]);
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += (rightMax - height[right]);
            }
        }
        return trappedWater;
    }
}