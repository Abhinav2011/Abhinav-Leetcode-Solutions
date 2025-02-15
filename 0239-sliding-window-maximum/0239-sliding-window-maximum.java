class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int currIndex=0;currIndex<nums.length;++currIndex) {

            if(!dq.isEmpty() && currIndex - k >= 0) {
                list.add(nums[dq.peekFirst()]);
            }

            if(!dq.isEmpty() && (currIndex - dq.peekFirst()) >= k) {
                dq.pollFirst();
            }
            //make sure a decreasing order is mainted
            while(!dq.isEmpty() && nums[currIndex] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            //add the curr element to last
            dq.offerLast(currIndex);
        }
        list.add(nums[dq.peekFirst()]);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}