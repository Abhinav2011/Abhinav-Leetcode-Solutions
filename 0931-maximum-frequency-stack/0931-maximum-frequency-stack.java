class FreqStack {
        int maxFreq;
        HashMap<Integer, Stack<Integer>> maxFreqTracker;
        HashMap<Integer,Integer> freq;
        public FreqStack() {
            maxFreq = 0;
            maxFreqTracker = new HashMap<>();
            freq = new HashMap<>();
        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            int currElementFreq = freq.get(val);
            Stack<Integer> st = maxFreqTracker.getOrDefault(currElementFreq, new Stack<>());
            st.push(val);
            maxFreqTracker.put(currElementFreq, st);
            maxFreq = Math.max(maxFreq, currElementFreq);
        }

        public int pop() {
            Stack<Integer> st = maxFreqTracker.get(maxFreq);
            int res = st.pop(); 
            freq.put(res, freq.get(res) - 1);
            if(freq.get(res) == 0) {
                freq.remove(res);
            }
            if(st.isEmpty()) {
                maxFreqTracker.remove(maxFreq);
                maxFreq--;
            }
            return res;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
