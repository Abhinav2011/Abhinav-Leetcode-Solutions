class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int lastIndex = piles.length - 1;
        int firstIndex = 0;
        int maxCoins = 0;
        while(firstIndex < lastIndex) {
            maxCoins += piles[lastIndex - 1];
            firstIndex++;
            lastIndex -= 2;
        }
        return maxCoins;
    }
}