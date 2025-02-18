class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;++i) {
            list.add(i + 1);
        }
        int index = 0;
        while(list.size() > 1) {
            int currIndex = index;
            int moves = 1;
            while(moves < k) {
                currIndex = (currIndex + 1) % list.size();
                moves++;
            }
            System.out.println(currIndex);
            list.remove(currIndex);
            index = currIndex;
        }
        return list.get(0);
    }
}