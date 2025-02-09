class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int[] pos = new int[2];
        while(left <= right) {
            mid = left + (right - left)/2;

            if(nums[mid] == target) {
                int leftEnd = mid, rightEnd = mid;
                while(leftEnd - 1 >= 0 && nums[leftEnd - 1] == nums[mid]) {
                    leftEnd--;
                }
                while(rightEnd + 1 < nums.length && nums[rightEnd + 1] == nums[mid]) {
                    rightEnd++;
                }
                System.out.println("mid = " + mid + " left = " + leftEnd + " right = " + rightEnd);
                pos[0] = leftEnd;
                pos[1] = rightEnd;
                return pos;

            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return new int[] {-1,-1};
    }
}