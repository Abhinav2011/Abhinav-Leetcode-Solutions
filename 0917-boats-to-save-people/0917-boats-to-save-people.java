class Solution {
    
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int counter = 0;
        int left = 0, right = people.length - 1;

        while(left <= right) {
            int sum = people[left] + people[right];
            counter++;
            if(sum <= limit) {
                left++;
                right--;
            }
            else {
                right--;
            }
        } 
        return counter;
    }
}