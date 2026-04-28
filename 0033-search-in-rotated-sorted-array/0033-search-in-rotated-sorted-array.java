class Solution {
    int ans = -1;
    private void findElement(int left, int right, int target, int[] nums) {
        if(ans != -1) {
            return;
        }
        if(left > right) {
            ans = -1;
            return;
        }

        if(left == right) {
            if(nums[left] == target) {
                ans = left;
            }
            return;
        }
        if(ans != -1) {
            return;
        }
        int mid = (left + right) / 2;
        // System.out.println(left + " " + right + " " + mid);
        if(nums[mid] == target) {
            ans = mid;
            return;
        }
        //Case : 1, left side is sorted
        if(nums[left] <= nums[mid] && nums[mid] > nums[right]) {
            if(target < nums[left]) {
                //search on the right side
                findElement(mid + 1, right, target, nums);
            }
            else {
                findElement(left, mid, target, nums);
            }
        }

        //Case : 2, right side is sorted
        if(nums[mid] <= nums[right] && nums[left] > nums[mid]) {
            if(target > nums[right]) {
                //search on the left side
                findElement(left, mid, target, nums);
            }
            else {
                System.out.println(left + " " + right + " " + mid);
                findElement(mid  + 1, right, target, nums);
            }
        }

        //Case 3 : normal sorted array
        if(target > nums[mid]) {
            findElement(mid + 1, right, target, nums);
        }
        else {
            findElement(left, mid, target, nums);
        }

    }
    public int search(int[] nums, int target) {
        findElement(0, nums.length - 1, target, nums);
        return ans;
    }
}