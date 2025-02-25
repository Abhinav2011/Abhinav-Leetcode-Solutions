class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0, high = col - 1;

        while(low < row && high >= 0) {
            if(matrix[low][high] == target) {
                return true;
            }
            if(matrix[low][high] < target) {
                low++;
            }
            else {
                high--;
            }
        }
        return false;
    }
}