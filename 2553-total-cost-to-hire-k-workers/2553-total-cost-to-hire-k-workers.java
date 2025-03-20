class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        int left = candidates - 1, right = Math.max(len - candidates, left + 1);
        long res = 0;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        for(int i=0;i<=left;++i) {
            leftHeap.offer(costs[i]);
        }
        for(int i=right;i<len;++i) {
            rightHeap.offer(costs[i]);
        }
    
        while(k-- > 0) {
           
            int minFromLeft = Integer.MAX_VALUE;
            int minFromRight = Integer.MAX_VALUE;
            if(!leftHeap.isEmpty()) {
                minFromLeft = leftHeap.peek();
            }
            if(!rightHeap.isEmpty()) {
                minFromRight = rightHeap.peek();
            }
            if(minFromLeft <= minFromRight) {
                res += leftHeap.poll();
                left++;
                if(left < right) {
                    leftHeap.offer(costs[left]);
                }
            }
            else {
                res += rightHeap.poll();
                right--;
                if(right > left) {
                    rightHeap.offer(costs[right]);
                }
            }
        }
        return res;
    }
}

// 17 12 10 2 7 2 11 20 8 k = 3, can = 4
// 17 12 10 7 2 11 20 8
// 17 12 10 7 11 20 8