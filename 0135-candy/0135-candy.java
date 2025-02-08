class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;

        if(len == 1) {
            return 1;
        }
        
        int[] candies = new int[len];
        Arrays.fill(candies, -1);
        candies[0] = 1;
        for(int i=1;i<len;++i) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = 1 + candies[i - 1];
            }
            else {
                candies[i] = 1;
            }
        }
        for(int i=len-2;i>=0;i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i + 1]);
            }
        }
        
        int minSum = Arrays.stream(candies).sum();
        return minSum;
    }
}