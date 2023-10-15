class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int num : nums){
            map.put(num,false);
        }
        int longestSeq = 0;
        for(int num : nums){
            int curr = num;
            int currLength = 1;
            map.put(num,true);
            while(map.get(curr - 1) != null && map.get(curr - 1) == false){
                map.put(curr - 1,true);
                currLength++;
                curr -= 1;
            }
            curr = num;
            while(map.get(curr + 1) != null && map.get(curr + 1) == false){
                map.put(curr + 1,true);
                currLength++;
                curr += 1;
            }
            longestSeq = Math.max(longestSeq,currLength);
        }
        return longestSeq;
    }
}