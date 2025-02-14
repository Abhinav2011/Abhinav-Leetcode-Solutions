class Solution {
    public int maximumSum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        int len = arr.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int currMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i<len;++i) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            globalMax = Math.max(globalMax, currMax);
            leftMax[i] = currMax;
        }
        int maxSum = globalMax;
        System.out.println(globalMax);
        currMax = 0;
        globalMax = 0;
        for(int i=len-1;i>=0;i--) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            globalMax = Math.max(globalMax, currMax);
            rightMax[i] = currMax;
        }
        for(int i=0;i<len;++i) {
            if(arr[i] < 0) {
                int leftMaxValue = 0, rightMaxValue = 0;
                if(i != 0) {
                    leftMaxValue = leftMax[i - 1];
                }
                if(i != len - 1) {
                    rightMaxValue = rightMax[i + 1];
                }
                System.out.println(leftMaxValue + " and " + rightMaxValue);
                maxSum = Math.max(maxSum, leftMaxValue + rightMaxValue);
            }
        }
        return maxSum;
        
    }
}

// 1 -4 -2 5 0 -1 2 