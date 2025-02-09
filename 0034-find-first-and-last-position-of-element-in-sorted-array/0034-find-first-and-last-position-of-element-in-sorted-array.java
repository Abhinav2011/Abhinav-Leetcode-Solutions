class Solution {
    private int leftSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid, ans = -1;
        while(left <= right) {
            mid = left + (right - left)/2;

            if(nums[mid] == target) {
                if(mid == 0) {
                    ans = mid;
                    break;
                }
                else if(mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    ans = mid - 1;
                    right = mid - 1;
                }
                else {
                    ans = mid;
                    break;
                }
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int rightSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid, ans = -1;
        while(left <= right) {
            mid = left + (right - left)/2;

            if(nums[mid] == target) {
                if(mid == nums.length - 1) {
                    ans = mid;
                    break;
                }
                else if(mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                    ans = mid + 1;
                    left = mid + 1;
                }
                else {
                    ans = mid;
                    break;
                }
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];
        pos[0] = leftSearch(nums, target);
        pos[1] = rightSearch(nums, target);
        return pos;
    }
}