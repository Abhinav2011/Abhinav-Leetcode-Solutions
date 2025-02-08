class Solution {
    int totalCombo = 0;
    private int calculatePermutations(int index, int amount, int[] coins, int[][] cache) {
        if(index >= coins.length || amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        
        if(cache[index][amount] != -1) {
            return cache[index][amount];
        }

        //first pick this amount
        int pick = calculatePermutations(index, amount - coins[index], coins, cache);
        //do not pick this amount
        int notPick = calculatePermutations(index + 1, amount, coins, cache);
        
        return cache[index][amount] = pick + notPick;
        
    }
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount + 1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int totalCombo = calculatePermutations(0, amount, coins, cache);
        return totalCombo;
    }
}