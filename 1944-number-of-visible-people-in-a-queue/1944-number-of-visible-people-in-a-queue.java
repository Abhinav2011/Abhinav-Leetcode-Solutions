class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        Arrays.fill(res, 0);

        Stack<Integer> stack = new Stack<>();

        for(int i=len-1;i>=0;i--) {
            if(stack.isEmpty()) {
                stack.push(heights[i]);
                res[i] = 1;
                continue;
            }
            int deletedCount = 0;
            while(!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                deletedCount++;
            }
            System.out.println(i + " -> " + deletedCount);
            if(deletedCount == 0) {
                res[i] += 1;
            }
            else {
                if(!stack.isEmpty() && stack.peek() >= heights[i]) {
                    res[i] += 1;
                } 
                res[i] += deletedCount;
            }
            
            stack.push(heights[i]);
        }
        res[len - 1] = 0;
        return res;
    }
}