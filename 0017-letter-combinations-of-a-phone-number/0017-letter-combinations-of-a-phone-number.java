class Solution {
    List<String> combinations = new ArrayList<>();
    public void helper(int index, StringBuilder temp, String digits, HashMap<Character,String> map) {
        if(index >= digits.length()) {
            combinations.add(temp.toString());
            return;
        }

        String mapping = map.get(digits.charAt(index));
        for(int i=0;i<mapping.length();++i) {
            char curr = mapping.charAt(i);
            temp.append(curr);
            helper(index + 1,temp,digits,map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return combinations;
        }
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        helper(0, new StringBuilder(), digits, map);
        return combinations;
    }
}
