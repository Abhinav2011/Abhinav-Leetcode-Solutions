class Solution {
   public boolean canTransform(String start, String result) {
        if(start.length() != result.length()) {
            return false;
        }
        int len = start.length();
        if(len == 1) {
            return start.charAt(0) == result.charAt(0);
        }

        int i = 0, j = 0;

        while(i <= len && j <= len) {
            while(i < len && start.charAt(i) == 'X') {
                i++;
            }
            while(j < len && result.charAt(j) == 'X') {
                j++;
            }

            if(i == len && j == len) {
                return true;
            }

            if((i == len || j == len)) {
                return false;
            }
            if(start.charAt(i) != result.charAt(j)) {
                return false;
            }

            if(start.charAt(i) == 'L' && i < j) {
                return false;
            }

            if(start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}