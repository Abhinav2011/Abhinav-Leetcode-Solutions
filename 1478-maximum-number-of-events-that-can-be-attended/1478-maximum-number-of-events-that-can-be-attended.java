class Solution {
    private int search(int[][] events) {
        int attend = 0;
        Arrays.sort(events, (a,b) -> {
            if(a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        HashSet<Integer> usedDays = new HashSet<>();
        int startDay = events[0][0];
        for(int[] event : events) {
            startDay = Math.min(event[0], startDay);
        }
        for(int[] event : events) {
            int start = event[0];
            int end = event[1];
            while(usedDays.contains(startDay)) {
                startDay++;
            }
            if(start <= startDay && startDay <= end) {
                usedDays.add(startDay);
                startDay++;
                attend++;
            }
            else {
                if(startDay <= start) {
                    for(int i=start;i<=end;++i) {
                        if(!usedDays.contains(i)) {
                            usedDays.add(i);
                            attend++;
                            break;
                        }
                    }
                }
            }
        }
        return attend;
    }

    public int maxEvents(int[][] events) {
        return search(events);
    }
}