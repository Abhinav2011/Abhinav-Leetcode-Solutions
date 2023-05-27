class Solution {
    public String rankTeams(String[] votes) {
        Map<Character,int[]> score = new HashMap<>();

        for(String vote : votes) {
            int len = vote.length();
            for(int index=0;index<len;++index) {
                char can = vote.charAt(index);
                score.putIfAbsent(can, new int[len]);
                score.get(can)[index]++;
            }
        }
        
        List<Character> teams = new ArrayList<>(score.keySet());
        Collections.sort(teams, (a, b) -> {
            int len = votes[0].length();
            for(int index=0;index<len;++index) {
                if(score.get(a)[index] != score.get(b)[index]) {
                    return score.get(b)[index] - score.get(a)[index];
                }
            }
            return a- b;
        });
        StringBuilder sb = new StringBuilder();
        for(char c : teams) {
            sb.append(c);
        }
        return sb.toString();
    }
}
/*
A - 1 1 1 1 1 5
B - 2 3 2 3 3 13
C - 3 2 3 2 2 12

W - 1 4 = 5
X - 2 1 = 3
Y - 3 2 = 5
Z - 4 3 = 7
  1 2 3 4
W 1     1

Y 0 1 

W*/