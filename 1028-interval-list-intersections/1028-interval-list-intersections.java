class Solution {
   public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstListLength = firstList.length;
        int secondListLength = secondList.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<firstListLength;++i) {
            int leftEnd = firstList[i][0];
            int rightEnd = firstList[i][1];
            boolean changed = false;
            for(int j=0;j<secondListLength;++j) {
                if(leftEnd >= secondList[j][0] && leftEnd <= secondList[j][1]) {
                    leftEnd = firstList[i][0];
                    changed = true;
                }
                else if(secondList[j][0] >= leftEnd && secondList[j][0] <= rightEnd) {
                    leftEnd = secondList[j][0];
                    changed = true;
                }

                //condition - 2
                if(rightEnd >= secondList[j][0] && rightEnd <= secondList[j][1]) {
                    rightEnd = firstList[i][1];
                    changed = true;
                }
                else if(secondList[j][1] >= leftEnd && secondList[j][1] <= rightEnd) {
                    rightEnd = secondList[j][1];
                    changed = true;
                }

                if(changed) {
                    int[] intersection = {leftEnd, rightEnd};
                    list.add(intersection);
                    leftEnd = firstList[i][0];
                    rightEnd = firstList[i][1];
                    changed = false;
                }
            }
        }
        
        int[][] answer = new int[list.size()][2];
        for(int i=0;i<list.size();++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}