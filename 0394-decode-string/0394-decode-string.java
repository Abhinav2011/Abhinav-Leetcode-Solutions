class Solution {
    public String decodeString(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<len;++i) {
            if(stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ']') {
                //get the string
                StringBuilder value = new StringBuilder();
                while(!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
                    value.append(stack.pop());
                }
                String original = value.reverse().toString();
                //remove [ from stack;
                stack.pop();
                StringBuilder times = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    times.append(stack.pop());
                }
                times.reverse();
                int timeInInteger = Integer.parseInt(times.toString()) - 1;
                System.out.println(value.toString() + " and times - " + times);
                while(timeInInteger-- > 0) {
                    value.append(original);
                }
                for(int k=0;k<value.length();++k) {
                    stack.add(value.charAt(k));
                }
            }
            else {
                stack.add(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}