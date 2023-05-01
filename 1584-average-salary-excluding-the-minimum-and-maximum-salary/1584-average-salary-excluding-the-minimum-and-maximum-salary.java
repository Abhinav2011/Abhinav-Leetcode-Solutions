class Solution {
    public double average(int[] salary) {
         int max = Arrays.stream(salary).max().getAsInt();
         int min = Arrays.stream(salary).min().getAsInt();
         int length = salary.length;
         double average = 0;
         for(int value : salary) {
             if(value != max && value != min) {
                 average += value;
             }
         }

         return (double) (average) / (length - 2);
    }
}