class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>(); //store index
        int ramp = 0;
        
        for(int i=0;i<nums.length;++i) {
            if(stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
                stack.add(i);
            }
        }
        for(int i=nums.length - 1;i>=0;i--) {
            if(stack.isEmpty()) {
                break;
            }
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                ramp = Math.max(ramp, i - stack.peek());
                stack.pop();
            }
        }
        return ramp;
    }
}