class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int size : asteroids) {
            while(!stack.isEmpty() && (size < 0 && stack.peek() > 0)) {
                if(stack.peek() == Math.abs(size)) {
                    stack.pop();
                    size = 0;
                    break;
                }
                else if(stack.peek() < Math.abs(size)) {
                    stack.pop();
                }
                else {
                    size = 0;
                    break;
                }
            }
            
            if(size != 0) {
                stack.add(size);
            }
        }
        int[] answer = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}