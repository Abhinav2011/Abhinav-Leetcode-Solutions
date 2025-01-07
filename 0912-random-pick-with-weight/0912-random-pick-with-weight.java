class Solution {

    int[] prefixSum;
        int totalSum;

        Random random;
        public Solution(int[] w) {
            prefixSum = new int[w.length];
            totalSum = w[0];
            random = new Random();
            prefixSum[0] = w[0];
            for(int i=1;i<w.length;++i) {
                prefixSum[i] = prefixSum[i - 1] + w[i];
                totalSum += w[i];
            }
        }

        public int pickIndex() {
            int target = random.nextInt(0, totalSum) + 1;
            int left = 0, right = prefixSum.length - 1;
            System.out.println(target);
            while(left < right) {
                int mid = (left + right) / 2;
                if(prefixSum[mid] == target) {
                    return mid;
                }
                else if(prefixSum[mid] > target) {
                   right = mid;
                }
                else {
                   left = mid + 1;
                }
            }
            return left;
        }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */