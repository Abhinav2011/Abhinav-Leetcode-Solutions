class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            result.append("-");
        }

        long num = (long) numerator;
        long den = (long) denominator;

        result.append(Math.abs(num/den));
        long remainder = num % den;
        if(remainder == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long,Integer> remainderMap = new HashMap<>();

        while(remainder != 0) {
            if(remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            else {
                remainderMap.put(remainder, result.length());
                remainder *= 10;
                result.append(Math.abs(remainder / den));
                remainder %= den;
            }
        }
        
        return result.toString();

    }
}