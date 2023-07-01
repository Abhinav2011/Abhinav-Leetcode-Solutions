class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int index=0;index<s.length();++index) {
            char c = s.charAt(index);
            if(st.isEmpty()) {
                st.add(c);
                continue;
            }
            
            if (!st.isEmpty() && ((st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}') || (st.peek() == '[' && c == ']'))) {
                st.pop();
            }
            else {
                st.add(c);
            }
        }
        return (st.isEmpty());
    }
}