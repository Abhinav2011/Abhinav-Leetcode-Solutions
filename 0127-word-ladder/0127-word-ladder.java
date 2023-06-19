class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        for(String s : wordList) {
            words.add(s);
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        int wordsTaken = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int index=0;index<size;++index) {
                String currWord = q.poll();
                if(currWord.equals(endWord)) {
                    return wordsTaken + 1;
                }
                for(int i=0;i<currWord.length();++i) {
                    StringBuilder sb = new StringBuilder(currWord);
                    for(char c='a';c<='z';++c) {
                        sb.setCharAt(i, c);
                        if(!visited.contains(sb.toString()) && words.contains(sb.toString())) {
                            q.add(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                }
            }
            wordsTaken++;
        }
        return 0;
    }
}