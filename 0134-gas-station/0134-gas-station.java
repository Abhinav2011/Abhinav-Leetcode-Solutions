class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int totalSum = 0;
        int startingTank = -1;
        for(int index=0;index<gas.length;++index) {
            if(tank <= 0) {
                startingTank = index;
                tank = (gas[index] - cost[index]);
            }
            else {
                tank = tank + gas[index] - cost[index];
            }
            totalSum += (gas[index] - cost[index]);
        }
        System.out.println(totalSum);
        if(totalSum < 0) {
            startingTank = -1;
        }
        return startingTank;
    }
}