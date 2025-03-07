class Solution {
    class Node {
        int value;
        int index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Node> left = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<len;++i) {
            int start = i;
            if(left.isEmpty()) {
                left.push(new Node(heights[i], i));
                continue;
            }
            while(!left.isEmpty() && heights[i] < left.peek().value) {
                Node node = left.pop();
                int dis = i - node.index;
                int area = node.value * dis;
                start = node.index;
                maxArea = Math.max(maxArea, area);
            }
            left.push(new Node(heights[i], start));
        }
        while(!left.isEmpty()) {
            Node node = left.pop();
            int dis = len - node.index;
            int area = node.value * dis;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}