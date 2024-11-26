class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length - 1;
        int[] prefix = new int[len + 1];
        int[] postfix = new int[len + 1];
        prefix[0] = nums[0];
        postfix[len] = nums[len];
        for(int i=1;i<=len;++i) {
            prefix[i] = Math.max(prefix[i - 1], nums[i]); 
        }
        for(int i=len-1;i>=0;i--) {
            postfix[i] = Math.min(postfix[i + 1], nums[i]);
        }
        int start = -1;
        int end = -1;
        for(int i=0;i<=len;++i) {
            if(prefix[i] != postfix[i] && start == -1) {
                start = i;
            }
            else if(prefix[i] != postfix[i]) {
                end = i;
            }
        }
        if(start == -1) return 0;
        return (end - start + 1);
    }
}