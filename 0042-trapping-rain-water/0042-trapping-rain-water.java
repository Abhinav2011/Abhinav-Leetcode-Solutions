class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for(int index=1;index<len;++index) {
            left[index] = Math.max(left[index - 1], height[index]);
        }
        right[len - 1] = height[len - 1];
        for(int index=len-2;index>=0;index--) {
            right[index] = Math.max(right[index + 1], height[index]);
        }
        
        int trappedWater = 0;
        for(int index=1;index<len-1;++index) {
            int currHeight = Math.min(left[index],right[index]) - height[index];
            trappedWater += currHeight;
        }
        return trappedWater;
    }
}