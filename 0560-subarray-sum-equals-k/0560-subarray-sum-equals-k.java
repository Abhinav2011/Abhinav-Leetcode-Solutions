class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int numberOfSubArray = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i=1;i<nums.length;++i) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        for(int right=0;right<nums.length;++right) {
            if(prefix[right] == k) {
                numberOfSubArray++;
            }
            int rem = prefix[right] - k;
            if(map.containsKey(rem)) {
                numberOfSubArray += map.get(rem);
            }
            map.put(prefix[right], map.getOrDefault(prefix[right], 0) + 1);
        }
        return numberOfSubArray;
    }

}