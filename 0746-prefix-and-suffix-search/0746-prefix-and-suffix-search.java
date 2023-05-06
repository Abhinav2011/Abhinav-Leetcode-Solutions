class TrieNode {
    public int index;
    public TrieNode[] child;
    public boolean isWord;
    public TrieNode() {
        this.index = -1;
        this.child = new TrieNode[27];
        this.isWord = false;
    }
}


interface TrieFunctions {
    public void insert(String word, int index);
    public int search(String word);
}

class Trie implements TrieFunctions {
    TrieNode root;

    Trie(TrieNode root) {
        this.root = root;
    }

    @Override
    public void insert(String word,int index) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c - 'a'] == null) {
                curr.child[c - 'a'] = new TrieNode();
            }
            curr = curr.child[c - 'a']; 
            curr.index = index;
        }
        curr.isWord = true;
    }

    @Override
    public int search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c - 'a'] == null) {
                System.out.println("reached");
                return -1;
            }
            curr = curr.child[c - 'a'];
        }
        if(curr.isWord == true) {
            return curr.index;
        }
        return -1;
    }

} 

class WordFilter {
    String[] words;
    // Trie trie;
    Map<String,Integer> map;
    public WordFilter(String[] words) {
        this.words = words;
        this.map = new HashMap<>();
        int index = 0;

        for(String word : words) {
            for(int preIndex = 0;preIndex < word.length();++preIndex) {
                String prefix = word.substring(0,preIndex + 1);
                for(int sufIndex = word.length() - 1;sufIndex >= 0;sufIndex--) {
                    String suffix = word.substring(sufIndex);
                    String key = prefix + "{" + suffix;
                    map.put(key, index);
                }
            }
            index++;
        }
    }
    
    public int f(String pref, String suff) {
        String key = pref + "{" + suff;
        int foundIndex = map.getOrDefault(key, -1);
        return foundIndex;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */

 /**
 (5 - 1)
 apple
 ap e
  */