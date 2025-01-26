class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        Boolean[] canMake = new Boolean[len];
        Arrays.fill(canMake, false);
        
        for(int i=0;i<len;++i) {
            int distanceFromHere = len - i;
            if(distanceFromHere >= k) {
                canMake[i] = true;
            }
        }
        
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        
        for(int i=0;i<len;++i) {
            if(canMake[i]) {
                if(nums[i] < minValue) {
                    minValue = nums[i];
                    minValueIndex = i;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int start=minValueIndex;start<len;++start) {
            if(stack.isEmpty()) {
                stack.add(nums[start]);
                continue;
            }
            
            if(nums[start] < stack.peek()) {
                int remDistance = len - start;
                while(nums[start] < stack.peek() && remDistance >= k - stack.size() + 1) {
                    stack.pop();
                }
            }
            stack.add(nums[start]);
        }
        while(stack.size() > k) {
            stack.pop();
        }
        int[] answer = new int[stack.size()];
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        for(int i=0;i<list.size();++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}