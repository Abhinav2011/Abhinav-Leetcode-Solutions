class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int maxArea = 0;
        for(int index=0;index<len;++index) {
            int start = index;
            while(!st.isEmpty() && st.peek().getValue() > heights[index]) {
                int currArea = st.peek().getValue() * (index - st.peek().getKey());
                maxArea = Math.max(maxArea, currArea);
                start = st.peek().getKey();
                st.pop();
            }
            st.add(new Pair(start, heights[index]));
        }
        while(!st.isEmpty()) {
            Pair<Integer,Integer> pair = st.pop();
            int index = pair.getKey();
            int height = pair.getValue();
            int currArea = (len - index) * height;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}