class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> cannotVisit = new HashSet<>();

        for(String state : deadends) {
            cannotVisit.add(state);
        }
        int totalTurns = 0;
        Queue<String> states = new LinkedList<>();
        HashSet<String> visitedStates = new HashSet<>();
        states.offer("0000");
        visitedStates.add("0000");
        if(cannotVisit.contains("0000")) {
            return -1;
        }
        while(!states.isEmpty()) {
            int size = states.size();
            for(int index=0;index<size;++index) {
                String currentState = states.poll();
                StringBuilder current = new StringBuilder(currentState);
                if(currentState.equals(target)) {
                    return totalTurns;
                }

                for(int slot=0;slot<4;++slot) {
                    char c = current.charAt(slot);
                    String turnUpState = current.substring(0, slot) + (c == '9' ? 0 : c - '0' + 1) + current.substring(slot + 1);
                    String turnDownState = current.substring(0, slot) + (c == '0' ? 9 : c - '0' - 1) + current.substring(slot + 1);
                    System.out.println(turnUpState + " and " + turnDownState);
                    if(!visitedStates.contains(turnUpState) && !cannotVisit.contains(turnUpState)) {
                        states.offer(turnUpState);
                        visitedStates.add(turnUpState);
                    }

                    if(!visitedStates.contains(turnDownState) && !cannotVisit.contains(turnDownState)) {
                        states.offer(turnDownState);
                        visitedStates.add(turnDownState);
                    }
                }
            }

            totalTurns++;
           
        }


        return -1;
    }
}

// 0 0 0 0


// 0 2 0 2