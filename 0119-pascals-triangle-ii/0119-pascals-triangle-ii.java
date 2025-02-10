class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1)));
        list.add(new ArrayList<>(List.of(1,1)));
        if(rowIndex == 0 || rowIndex == 1) {
            if(rowIndex == 0) {
                return list.get(0);
            }
            return list.get(1);
        }
        for(int i=2;i<=rowIndex;++i) {
            List<Integer> prev = list.get(i - 1);
            Integer[] curr = new Integer[i + 1];
            curr[0] = 1;
            curr[i] = 1;
            for(int k=1;k<curr.length-1;++k) {
                curr[k] = prev.get(k) + prev.get(k - 1);
            }
            list.add(new ArrayList<>(List.of(curr)));
        }
        return list.get(rowIndex);
    }
}