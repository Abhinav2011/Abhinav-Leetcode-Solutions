
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        Arrays.fill(res, 0);
        if(n == 1) {
            return res;
        }
        int[] nums = new int[n];
        int answer = 0;
        for(int i=0;i<len;++i) {
            int index = queries[i][0];
            int colour = queries[i][1];
            if(index == 0) {
                if(nums[index] == nums[index + 1] && nums[index] != colour) {
                    if(nums[index] == 0 && nums[index + 1] == 0) {
                        nums[index] = colour;
                    }
                    else {
                        answer--;
                        nums[index] = colour;
                    }
                
                }
                else if(nums[index] != nums[index + 1]) {
                    nums[index] = colour;
                    if (nums[index] == nums[index + 1]) {
                        answer++;
                    }
                }
            }
            else if(index == n - 1) {
                if(nums[index] == nums[index - 1] && nums[index] != colour) {
                    if(nums[index] == 0 && nums[index - 1] == 0) {
                        nums[index] = colour;
                    }
                    else {
                        answer--;
                        nums[index] = colour;
                    }
                }
                else if(nums[index] != nums[index - 1]) {
                    nums[index] = colour;
                    if (nums[index] == nums[index - 1]) {
                        answer++;
                    }
                }
            }
            else {
                if(nums[index] == nums[index + 1] && nums[index] != colour) {
                    if(nums[index] == 0 && nums[index + 1] == 0) {
                    }
                    else {
                        answer--;
                    }
                }
                else if(nums[index] != nums[index + 1]) {
                    if (colour == nums[index + 1]) {
                        answer++;
                    }
                }

                if(nums[index] == nums[index - 1] && nums[index] != colour) {
                    if(nums[index] == 0 && nums[index - 1] == 0) {
                    }
                    else {
                        answer--;
                    }
                }
                else if(nums[index] != nums[index - 1]) {
                    if (colour == nums[index - 1]) {
                        answer++;
                    }
                }

                nums[index] = colour;
            }
            res[i] = answer;
        }
        return res;
    }
}