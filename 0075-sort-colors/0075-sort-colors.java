class Solution {
    public void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public void sortColors(int[] nums) {
        int size = nums.length;

        int left = 0, mid = 0, right = size - 1;

        while(mid <= right) {
            if(nums[mid] == 0) {
                swap(nums, mid, left);
                left++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else{
                swap(nums, mid, right);
                right--;
            }
        }

    }
}

