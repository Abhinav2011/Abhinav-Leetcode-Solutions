class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2) -> Integer.compare(o1[0],o2[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        for(int index=1;index<intervals.length;++index) {
            int start = intervals[index][0];
            int end = intervals[index][1];

            if(currStart <= end && currEnd >= start) {
                currEnd = Math.max(currEnd, end);
                currStart = Math.min(currStart, start);
            }
            else {
                List<Integer> temp = new ArrayList<>(Arrays.asList(currStart, currEnd));
                ans.add(temp);
                currStart = start;
                currEnd = end;
            }
        }
        List<Integer> temp = new ArrayList<>(Arrays.asList(currStart, currEnd));
        ans.add(temp);
        int[][] merged = new int[ans.size()][ans.get(0).size()];
        for(int i=0;i<ans.size();++i) {
            for(int j=0;j<ans.get(0).size();++j) {
                merged[i][j] = ans.get(i).get(j);
            }
        }
        return merged;
    }
}