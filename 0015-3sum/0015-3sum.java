class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allSets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i) {
            int target = -(nums[i]);
            System.out.println("Starting with = " + nums[i]);
            //I know array after this index is sorted
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    //found some result
                    allSets.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    } 
                }
                else if(sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
            while((i != nums.length - 1) && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return allSets;
    }
}