class Solution {
     public int maxScore(int index, int prevIndex, List<int[]> data, int[][] dp) {
        if(index >= data.size()) {
            return 0;
        }
        if(dp[index][prevIndex + 1] != 0) {
            return dp[index][prevIndex + 1];
        }
        //pick this score
        int pickedScore = 0;
        if(prevIndex == -1 || data.get(index)[1] >= data.get(prevIndex)[1]) {
            pickedScore = data.get(index)[1] + maxScore(index + 1, index, data, dp);
        }
        int notPickedScore = maxScore(index + 1, prevIndex, data, dp);
        return dp[index][prevIndex + 1] = Math.max(pickedScore, notPickedScore);

    }
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> data = new ArrayList<>();
        for(int i=0;i<scores.length;++i) {
            int[] arr = {ages[i], scores[i]};
            data.add(arr);
        }

        Collections.sort(data, (arr1, arr2) ->  {
            if (arr1[0] != arr2[0]) {
                return Integer.compare(arr1[0], arr2[0]); // Compare by ages
            } else {
                return Integer.compare(arr1[1], arr2[1]); // Compare by scores if ages are equal
            }
        });

        int[][] dp = new int[scores.length][scores.length];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        return maxScore(0, -1, data, dp);
    }
}